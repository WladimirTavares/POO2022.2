import javax.swing.JFrame;
import javax.swing.JLabel;

public class GUI1 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Primeiro programa");
        JLabel label = new JLabel("Hello World");
        frame.setSize(800,500);
        frame.getContentPane().add(label);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
