import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

class Exemplo2 {
    public static void main(String[] args) {

        try {
            OutputStream out = new FileOutputStream("hello.out");
            String s = "Hello World";
            for(int i = 0; i < s.length(); i++){
                out.write( s.charAt(i) );
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
