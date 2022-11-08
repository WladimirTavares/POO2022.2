import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.FileOutputStream;
import java.io.BufferedWriter;

public class Exemplo5 {
    public static void main(String[] args) {
        try {
            OutputStream out = new FileOutputStream("hello.out");
            OutputStreamWriter osr = new OutputStreamWriter(out, "UTF-8");
            BufferedWriter bw = new BufferedWriter(osr);

            bw.write("Hello World!!!\nAula de InputOutputStream\n");
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}