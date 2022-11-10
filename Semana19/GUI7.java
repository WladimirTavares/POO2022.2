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

public class GUI7 extends JFrame {
    JLabel label1;
    JTextField textField1;
    JButton button1;
    int numero_secreto;
    String repr;
    Random rand;
    JLabel label2;
    int pontuacao = 0;

    private String romanNumber(int x) {
        String[] romanSymbols = { "I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M" };
        int[] romanValues = { 1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000 };
        String res = "";

        int pos = romanSymbols.length - 1;

        while (x > 0) {

            if (x >= romanValues[pos]) {
                res += romanSymbols[pos];
                x -= romanValues[pos];
            } else {
                pos--;
            }

        }

        return res;

    }

    public GUI7() {
        super("Numeracao Romana");

        rand = new Random();
        numero_secreto = rand.nextInt(999) + 1;
        repr = romanNumber(numero_secreto);

        label1 = new JLabel(repr + " = ");
        label2 = new JLabel("Sua pontuaçao =" + pontuacao);
        textField1 = new JTextField(6);
        button1 = new JButton("Enviar");
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        add(label2);
        add(label1);
        add(textField1);
        add(button1);

        button1.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        int n1 = Integer.parseInt(textField1.getText());
                        if (n1 == numero_secreto) {
                            JOptionPane.showMessageDialog(null,
                                    "Você acertou!!\nPronto para o novo desafio",
                                    "Resultado", JOptionPane.PLAIN_MESSAGE);
                            numero_secreto = rand.nextInt(99) + 1;
                            repr = romanNumber(numero_secreto);
                            label1.setText(repr + " = ");
                            textField1.setText("");
                            pontuacao++;
                            label2.setText("Sua pontuacao = " + pontuacao);
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "Infelizmente, você errou :( Tente novamente",
                                    "Resultado", JOptionPane.PLAIN_MESSAGE);
                            numero_secreto = rand.nextInt(99) + 1;
                            repr = romanNumber(numero_secreto);
                            label1.setText(repr + " = ");
                            textField1.setText("");
                        }
                    }
                });
    }

}
