import java.awt.*; // Using AWT's Graphics and Color
import java.awt.event.*; // Using AWT's event classes and listener interface
import javax.swing.*; // Using Swing's components and containers

/**
 * A Bouncing Ball: Running animation via a custom thread
 */
public class CGBouncingBall2 extends JFrame {
    // Define named-constants
    private static final int CANVAS_WIDTH = 640;
    private static final int CANVAS_HEIGHT = 480;
    private static final int UPDATE_INTERVAL = 20; // milliseconds

    private DrawCanvas canvas; // the drawing canvas (an inner class extends JPanel)

    // Attributes of moving object
    private int x = 100; // top-left (x, y)
    private int y = 100;
    private int size = 50; // width and height
    private int xSpeed = 3; // moving speed in x and y directions
    private int ySpeed = 5; // displacement per step in x and y

    // Constructor to setup the GUI components and event handlers
    public CGBouncingBall2() {
        canvas = new DrawCanvas();
        canvas.setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
        this.setContentPane(canvas);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setTitle("Bouncing Ball");
        this.setVisible(true);

        // Create a new thread to run update at regular interval
        Thread updateThread = new Thread() {
            @Override
            public void run() {
                while (true) {
                    repaint(); // Refresh the JFrame. Called back paintComponent()
                    try {
                        // Delay and give other thread a chance to run
                        Thread.sleep(UPDATE_INTERVAL); // milliseconds
                    } catch (InterruptedException ignore) {
                    }
                }
            }
        };
        updateThread.start(); // called back run()


        // "super" JFrame fires KeyEvent
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent evt) {
                switch (evt.getKeyCode()) {
                    case KeyEvent.VK_LEFT:
                        
                        if(x - size >= 0){
                            x -= size;
                        }

                        repaint();
                        break;
                    case KeyEvent.VK_RIGHT:
                        if(x + size < CANVAS_WIDTH){
                            x += size;
                        }
                        repaint();
                        break;

                    case KeyEvent.VK_UP:
                    if(y - size >= 0){
                        y -= size;
                    }
                    repaint();
                    break;
                    
                    case KeyEvent.VK_DOWN:
                    if(y + size < CANVAS_HEIGHT){
                        y += size;
                    }
                    repaint();
                    break;
                }
            }
        });
    }

    


    // Define Inner class DrawCanvas, which is a JPanel used for custom drawing
    class DrawCanvas extends JPanel {
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g); // paint parent's background
            setBackground(Color.BLACK);
            g.setColor(Color.BLUE);
            g.fillOval(x, y, size, size); // draw a circle
        }
    }

    // The entry main method
    public static void main(String[] args) {
        // Run GUI codes in Event-Dispatching thread for thread safety
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CGBouncingBall2(); // Let the constructor do the job
            }
        });
    }
}