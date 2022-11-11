import javax.swing.JFrame;

public class TesteJogoDaVelha {
    public static void main(String[] args) {
        JogoDaVelha frame = new JogoDaVelha();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400); // configura tamanho do frame
        frame.setVisible(true); // exibe frame
    }
}
