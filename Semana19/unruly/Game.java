import java.util.Scanner;



public class Game extends JFrame {
    Board b;
    GameStatus status;

    Game(){
        b = new Board();
        status = GameStatus.playing;

    }

}
