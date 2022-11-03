import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Exemplo3 {
    public static void main(String[] args) {
        try {
            InputStream is = new FileInputStream("hello.txt");
            InputStreamReader isr = new InputStreamReader(is, "UTF-8");
            int data;
            data = isr.read();
            while (data != -1) {
                System.out.println("Char : " + (char) data);
                data = isr.read();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
