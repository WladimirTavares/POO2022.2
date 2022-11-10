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
import java.text.Bidi;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI6 extends JFrame {
    private JLabel label1, label2;
    private DefaultListModel listModel;
    private JList lista1, lista2;
    private JButton button1;
    private JTextArea textArea1;

    public GUI6() {
        super("Pedra, papel e tesoura");
        label1 = new JLabel("Jogador 1:");

        listModel = new DefaultListModel<>();
        listModel.addElement("papel");
        listModel.addElement("pedra");
        listModel.addElement("tesoura");

        lista1 = new JList<>(listModel);
        lista1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        label2 = new JLabel("Jogador 2:");

        lista2 = new JList<>(listModel);
        lista2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        button1 = new JButton("Enviar");
        textArea1 = new JTextArea(10, 30);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        add(label1);
        add(lista1);
        add(label2);
        add(lista2);
        add(button1);
        add(textArea1);

        button1.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {

                        if (lista1.getSelectedIndex() == lista2.getSelectedIndex()) {
                            textArea1.append("empate\n");
                        } else if (lista1.getSelectedIndex() == 0) {
                            if (lista2.getSelectedIndex() == 1)
                                textArea1.append("Jogador 1 ganha\n");
                            if (lista2.getSelectedIndex() == 2)
                                textArea1.append("Jogador 2 ganha\n");
                        } else if (lista1.getSelectedIndex() == 1) {
                            if (lista2.getSelectedIndex() == 0)
                                textArea1.append("Jogador 2 ganha\n");
                            if (lista2.getSelectedIndex() == 2)
                                textArea1.append("Jogador 1 ganha\n");
                        }else {
                            if (lista2.getSelectedIndex() == 0)
                                textArea1.append("Jogador 1 ganha\n");
                            if (lista2.getSelectedIndex() == 1)
                                textArea1.append("Jogador 2 ganha\n");
                        }
                    }
                });
    }

}
