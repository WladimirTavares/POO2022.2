import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.FileInputStream;

public class Exemplo4 {
    public static void main(String[] args) {
        try{
            InputStream is = new FileInputStream("hello.txt");
            InputStreamReader isr = new InputStreamReader(is, "UTF-8");
            BufferedReader br = new BufferedReader(isr);

            System.out.println( br.readLine() );
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
