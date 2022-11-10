import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.BoxLayout;

public class GUI1 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Primeiro programa");
        JLabel label = new JLabel("Nome: ");
        JButton button = new JButton("OK");
        JTextField textField = new JTextField(20);
        frame.setSize(800,500);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        frame.getContentPane().add(label);
        frame.getContentPane().add(textField);
        frame.getContentPane().add(button);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
