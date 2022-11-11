import javax.swing.JFrame;
public class TesteUnruly {
    public static void main(String[] args) {
        Unruly unruly = new Unruly();
        unruly.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        unruly.setSize(400, 400); // configura tamanho do frame
        unruly.setVisible(true); // exibe frame
    }
}
