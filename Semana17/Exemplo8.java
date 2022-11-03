import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class Exemplo8 {
    public static void main(String[] args) {
        try {
            OutputStream os = new FileOutputStream("hello.dat");
            DataOutputStream out = new DataOutputStream(os);
            out.writeInt(45);
            out.writeDouble(2.35);
            out.close();

            InputStream is = new FileInputStream("hello.dat");
            DataInputStream in = new DataInputStream(is);

            System.out.println( in.readInt() );
            System.out.println( in.readDouble() );

            in.close();
            

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}