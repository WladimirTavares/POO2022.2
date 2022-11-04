import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI4 extends JFrame {
    private JLabel label1;
    private JTextField textfield1;
    private JLabel label2;
    private JTextField textfield2;
    private JButton button1;
    private JLabel label3;
    private JTextField textfield3;

    public GUI4() {
        super("Somando números");

        label1 = new JLabel("Entre com um número");
        textfield1 = new JTextField(10);
        label2 = new JLabel("Entre com um número");
        textfield2 = new JTextField(10);
        button1 = new JButton("OK");
        label3 = new JLabel("Resultado: ");
        textfield3 = new JTextField(10);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        add(label1);
        add(textfield1);
        add(label2);
        add(textfield2);

        add(button1);

        add(label3);
        add(textfield3);
        

        button1.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int n1 = Integer.parseInt(textfield1.getText());
                int n2 = Integer.parseInt(textfield2.getText());
                Integer res = n1 + n2;
                System.out.println("chamando\n");
                textfield3.setText(res.toString());
            }
        } );
    }

    

}
