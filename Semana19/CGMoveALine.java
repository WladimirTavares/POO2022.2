import java.awt.*; // Using AWT's Graphics and Color
import java.awt.event.*; // Using AWT's event classes and listener interface
import javax.swing.*; // Using Swing's components and containers

/**
 * Custom Graphics Example: Using key/button to move a line left or right.
 */
@SuppressWarnings("serial")
public class CGMoveALine extends JFrame {
    // Define constants for the various dimensions
    public static final int CANVAS_WIDTH = 400;
    public static final int CANVAS_HEIGHT = 140;
    public static final Color LINE_COLOR = Color.BLACK;
    public static final Color CANVAS_BACKGROUND = Color.CYAN;

    // The moving line from (x1, y1) to (x2, y2), initially position at the center
    private int x1 = CANVAS_WIDTH / 2;
    private int y1 = CANVAS_HEIGHT / 8;
    private int x2 = x1;
    private int y2 = CANVAS_HEIGHT / 8 * 7;

    private DrawCanvas canvas; // The custom drawing canvas (an innder class extends JPanel)

    // Constructor to set up the GUI components and event handlers
    public CGMoveALine() {
        // Set up a panel for the buttons
        JPanel btnPanel = new JPanel(new FlowLayout());
        JButton btnLeft = new JButton("Move Left ");
        btnPanel.add(btnLeft);
        btnLeft.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                x1 -= 10;
                x2 -= 10;
                canvas.repaint();
                requestFocus(); // change the focus to JFrame to receive KeyEvent
            }
        });
        JButton btnRight = new JButton("Move Right");
        btnPanel.add(btnRight);
        btnRight.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                x1 += 10;
                x2 += 10;
                canvas.repaint();
                requestFocus(); // change the focus to JFrame to receive KeyEvent
            }
        });

        // Set up a custom drawing JPanel
        canvas = new DrawCanvas();
        canvas.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));

        // Add both panels to this JFrame's content-pane
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
                        x1 -= 10;
                        x2 -= 10;
                        repaint();
                        break;
                    case KeyEvent.VK_RIGHT:
                        x1 += 10;
                        x2 += 10;
                        repaint();
                        break;
                }
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Handle the CLOSE button
        setTitle("Move a Line");
        pack(); // pack all the components in the JFrame
        setVisible(true); // show it
        requestFocus(); // set the focus to JFrame to receive KeyEvent
    }

    /**
     * Define inner class DrawCanvas, which is a JPanel used for custom drawing.
     */
    class DrawCanvas extends JPanel {
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            setBackground(CANVAS_BACKGROUND);
            g.setColor(LINE_COLOR);
            g.drawLine(x1, y1, x2, y2); // Draw the line
        }
    }

    // The entry main() method
    public static void main(String[] args) {
        // Run GUI codes on the Event-Dispatcher Thread for thread safety
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CGMoveALine(); // Let the constructor do the job
            }
        });
    }
}