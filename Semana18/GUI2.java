import javax.swing.JOptionPane;

public class GUI2 {
    public static void main(String[] args) {
        String s1 = JOptionPane.showInputDialog("Entre com um número:");
        String s2 = JOptionPane.showInputDialog("Entre com um número:");

        int n1 = Integer.parseInt(s1);
        int n2 = Integer.parseInt(s2);

        JOptionPane.showMessageDialog(null, "A soma dos dois números é " + (n1 + n2), "Resultado", JOptionPane.PLAIN_MESSAGE);
        
        
    }
}
