import java.io.FileInputStream;
import java.io.InputStream;

class Exemplo1 {
    public static void main(String[] args) {

        try {
            InputStream is = new FileInputStream("hello.txt");
            int data;
            data = is.read();
            int cont = 0;
            while (data != -1) {
                System.out.println("Char : " + (char) data);

                if ((char) data == 'l') {
                    is.skip(1);
                }

                if ((char) data == '!') {
                    cont++;
                    System.out.println(cont);
                    if (cont == 1) {
                        is.mark(0);
                    } else if (cont == 2) {
                        if (is.markSupported()) {
                            System.out.println("reset() chamado");
                            is.reset();
                        } else {
                            System.out.println("reset() nao suportado");
                        }
                    }
                }

                data = is.read();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
