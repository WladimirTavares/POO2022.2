import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;


public class Unruly extends JFrame implements ActionListener {
    private Board board;
    private JPanel panel;
    private JButton [][] buttons;

    Unruly(){
        super("Unruly");
        board = new Board();
        panel = new JPanel();
        panel.setLayout(new GridLayout( board.getRows(), board.getCols()));

        buttons = new JButton[board.getRows()][board.getRows()];
        for(int i = 0; i < board.getRows(); i++){
            for(int j = 0; j < board.getCols(); j++){
                buttons[i][j] = new JButton();
                buttons[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                if( !board.isFixed(i, j) )
                    buttons[i][j].addActionListener(this);
                buttons[i][j].setBackground( board.getColor(i, j) );
                panel.add(buttons[i][j]);

            }
        }

        add(panel);

    }

    @Override
    public void actionPerformed(ActionEvent e){
        JButton button = (JButton) e.getSource();
        

        for(int i = 0; i < board.getRows(); i++){
            for(int j = 0; j < board.getCols(); j++){
                if( buttons[i][j] == button){
                    if( button.getBackground() == Color.GRAY ){
                        button.setBackground( Color.BLACK );
                        board.setColor(i, j, Color.BLACK);
                        if( !board.isValidMove(i, j, Color.BLACK) ){
                            button.setBorder(BorderFactory.createLineBorder(Color.RED));
                        }else{
                            button.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                        }

                    }else if( button.getBackground() == Color.BLACK ){
                        button.setBackground( Color.WHITE );
                        board.setColor(i, j, Color.WHITE);
                        if( !board.isValidMove(i, j, Color.WHITE) ){
                            button.setBorder(BorderFactory.createLineBorder(Color.RED));
                        }else{
                            button.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                        }
                        
                    }else {

                        button.setBackground( Color.GRAY );
                        board.setColor(i, j, Color.GRAY);
                        button.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    }
                }
            }
        }


    }

}
