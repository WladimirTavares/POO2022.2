import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.ListSelectionModel;
import java.util.List;
import java.util.Random;
import java.text.Bidi;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

class GUI8 extends JFrame {
    JLabel label1;
    JTextField text1;
    JButton button1;
    JLabel label2;
    JTextField text2;

    public GUI8() {
        super("Jogo do Estevam");

        label1 = new JLabel("Entre com um número");
        text1 = new JTextField(10);
        button1 = new JButton("Enviar");
        label2 = new JLabel("Resultado");
        text2 = new JTextField(10);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        add(label1);
        add(text1);
        add(button1);
        add(label2);
        add(text2);

        button1.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        int n = Integer.parseInt(text1.getText());
                        text2.setText(fib(n).toString());
                    }
                });
    }

    public Integer fib(int n) {
        if (n == 1 || n == 0) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

}
