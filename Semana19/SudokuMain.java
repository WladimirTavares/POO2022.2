

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * The main Sudoku program
 */
public class SudokuMain extends JFrame {
    private static final long serialVersionUID = 1L; // to prevent serial warning

    // private variables
    GameBoardPanel board = new GameBoardPanel();
    JButton btnNewGame = new JButton("New Game");

    // Constructor
    public SudokuMain() {
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(board, BorderLayout.CENTER);

        // Add a button to the south to re-start the game via board.newGame()
        cp.add(btnNewGame, BorderLayout.SOUTH);

        btnNewGame.addActionListener(
            new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    board.newGame();
                }
            }
        );

        // Initialize the game board to start the game
        board.newGame();

        pack(); // Pack the UI components, instead of using setSize()
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // to handle window-closing
        setTitle("Sudoku");
        setVisible(true);
    }

    /** The entry main() entry method */
    public static void main(String[] args) {
        // [TODO 1] Check "Swing program template" on how to run
        // the constructor of "SudokuMain"
        new SudokuMain();
    }
}