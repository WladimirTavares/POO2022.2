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

class GUI9 extends JFrame {
    


    public GUI8() {
        super("Jogo do Rodrigo");

        label1 = new JLabel("Sua pontuaçao =" + pontuacao);
        button1 = new JButton("Enviar");
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        add(label1);
        add(button1);

        button1.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                            pontuacao++;
                            label1.setText("Sua pontuacao = " + pontuacao);
                        } 
                });
    }

}


