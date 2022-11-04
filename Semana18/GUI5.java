import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
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

public class GUI5 extends JFrame {
    JList lista;
    DefaultListModel listModel;
    JLabel label1;
    JTextField textField1;
    JTextArea textArea1;
    JButton button1;

    public GUI5() {
        super("Lista de Frutas");

        listModel = new DefaultListModel<>();

        listModel.addElement("maça");
        listModel.addElement("banana");

        lista = new JList<>(listModel);
        lista.setSelectionMode(
                ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        textArea1 = new JTextArea(10, 50);
        label1 = new JLabel("Fruta");
        textField1 = new JTextField(20);
        button1 = new JButton("Adicionar Fruta");
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        add(lista);
        add(label1);
        add(textField1);
        add(button1);

        button1.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {

                        listModel.addElement(textField1.getText());
                        textField1.setText("");
                    }
                });

    }

}
