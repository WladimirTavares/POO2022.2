import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.nio.charset.StandardCharsets;

public class Exemplo6 {
    public static void main(String[] args) {
        try {
            FileWriter fstream = new FileWriter("hello.out", StandardCharsets.UTF_8, false);
            
            fstream.write("Hello OutputStream characteres!!!");
            fstream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}