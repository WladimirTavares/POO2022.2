import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI5 extends JFrame {
    
    JButton [][] buttons = new JButton[3][3];
    String [] jogador = {"X","O"};
    int joga_da_vez = 0;
    boolean terminou = false;

    public GUI5() {
        super("Jogo da Velha");
        JPanel controls = new JPanel();
        controls.setLayout(new GridLayout(3,3));

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                buttons[i][j] = new JButton("");
                controls.add(buttons[i][j]);
                buttons[i][j].addActionListener( 
                    new ActionListener(){
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            
                            if(terminou) 
                                return ;

                            JButton button = (JButton)e.getSource();
                            
                            if( button.getText() == ""){
                                button.setText(jogador[joga_da_vez]);
                                joga_da_vez = (joga_da_vez + 1)%2;
                            }else{
                                JOptionPane.showMessageDialog(null, "jogada inválida");
                            }

                            for(int i = 0; i < 3; i++){
                                int [] contJogador = new int[2];
                                contJogador[0] = 0;
                                contJogador[1] = 0;
                                for(int j = 0; j < 3; j++){
                                    if( buttons[i][j].getText().equals( jogador[0])){
                                        contJogador[0]++;
                                    }else if( buttons[i][j].getText().equals( jogador[0]) ){
                                        contJogador[1]++;
                                    }
                                }

                                if(contJogador[0] == 3){
                                    JOptionPane.showMessageDialog(null, "Primeiro Jogador Venceu");
                                    terminou = true;
                                }else if( contJogador[1] == 3){
                                    JOptionPane.showMessageDialog(null, "Segundo Jogador Venceu");
                                    terminou = true;
                                }
                            }

                            for(int j = 0; j < 3; j++){
                                int [] contJogador = new int[2];
                                contJogador[0] = 0;
                                contJogador[1] = 0;
                                for(int i = 0; i < 3; i++){
                                    if( buttons[i][j].getText().equals( jogador[0])){
                                        contJogador[0]++;
                                    }else if( buttons[i][j].getText().equals( jogador[0]) ){
                                        contJogador[1]++;
                                    }
                                }

                                if(contJogador[0] == 3){
                                    JOptionPane.showMessageDialog(null, "Primeiro Jogador Venceu");
                                    terminou = true;
                                }else if( contJogador[1] == 3){
                                    JOptionPane.showMessageDialog(null, "Segundo Jogador Venceu");
                                    terminou = true;
                                }
                            }

                        }
                    }
                );
            }
        }

        add(controls);

        


    }

}
