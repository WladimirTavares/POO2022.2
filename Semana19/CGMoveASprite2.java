import java.awt.*; // Using AWT's Graphics and Color
import java.awt.event.*; // Using AWT's event classes and listener interfaces
import javax.swing.*; // Using Swing's components and containers

/**
 * Custom Graphics Example: Using key/button to move a object left or right.
 * The moving object (sprite) is defined in its own class, with its own
 * operations and can paint itself.
 */
public class CGMoveASprite2 extends JFrame {
    // Define constants for the various dimensions
    public static final int CANVAS_WIDTH = 400;
    public static final int CANVAS_HEIGHT = 140;
    public static final Color CANVAS_BG_COLOR = Color.CYAN;

    private DrawCanvas canvas; // the custom drawing canvas (an inner class extends JPanel)
    private Sprite sprite; // the moving object

    // Constructor to set up the GUI components and event handlers
    public CGMoveASprite2() {
        // Construct a sprite given x, y, width, height, color
        sprite = new Sprite(CANVAS_WIDTH / 2 - 5, CANVAS_HEIGHT / 2 - 40,
                10, 80, Color.RED);

        // Set up a panel for the buttons
        JPanel btnPanel = new JPanel(new FlowLayout());
        JButton btnLeft = new JButton("Move Left ");
        btnPanel.add(btnLeft);
        btnLeft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                moveLeft();
                requestFocus(); // change the focus to JFrame to receive KeyEvent
            }
        });
        JButton btnRight = new JButton("Move Right");
        btnPanel.add(btnRight);
        btnRight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                moveRight();
                requestFocus(); // change the focus to JFrame to receive KeyEvent
            }
        });

        // Set up the custom drawing canvas (JPanel)
        canvas = new DrawCanvas();
        canvas.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));

        // Add both panels to this JFrame
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(canvas, BorderLayout.CENTER);
        cp.add(btnPanel, BorderLayout.SOUTH);

        // "super" JFrame fires KeyEvent
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent evt) {
                switch (evt.getKeyCode()) {
                    case KeyEvent.VK_LEFT:
                        moveLeft();
                        break;
                    case KeyEvent.VK_RIGHT:
                        moveRight();
                        break;
                }
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Move a Sprite");
        pack(); // pack all the components in the JFrame
        setVisible(true); // show it
        requestFocus(); // "super" JFrame requests focus to receive KeyEvent
    }

    // Helper method to move the sprite left
    private void moveLeft() {
        // Save the current dimensions for repaint to erase the sprite
        int savedX = sprite.x;
        // update sprite
        sprite.x -= 10;
        // Repaint only the affected areas, not the entire JFrame, for efficiency
        canvas.repaint(savedX, sprite.y, sprite.width, sprite.height); // Clear old area to background
        canvas.repaint(sprite.x, sprite.y, sprite.width, sprite.height); // Paint new location
    }

    // Helper method to move the sprite right
    private void moveRight() {
        // Save the current dimensions for repaint to erase the sprite
        int savedX = sprite.x;
        // update sprite
        sprite.x += 10;
        // Repaint only the affected areas, not the entire JFrame, for efficiency
        canvas.repaint(savedX, sprite.y, sprite.width, sprite.height); // Clear old area to background
        canvas.repaint(sprite.x, sprite.y, sprite.width, sprite.height); // Paint at new location
    }

    // Define inner class DrawCanvas, which is a JPanel used for custom drawing
    class DrawCanvas extends JPanel {
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            setBackground(CANVAS_BG_COLOR);
            sprite.paint(g); // the sprite paints itself
        }
    }

    // The entry main() method
    public static void main(String[] args) {
        // Run GUI construction on the Event-Dispatching Thread for thread safety
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CGMoveASprite(); // Let the constructor do the job
            }
        });
    }
}
