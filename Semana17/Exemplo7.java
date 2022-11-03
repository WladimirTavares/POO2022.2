import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

class Student{
    String nome;
    int matricula;
    public Student(String nome, int matricula) {
        this.nome = nome;
        this.matricula = matricula;
    }
    @Override
    public String toString() {
        return "Student [nome=" + nome + ", matricula=" + matricula + "]";
    }

}

public class Exemplo7 {
    public static void main(String[] args) {
        try {
            PrintWriter out = new PrintWriter("hello.out", StandardCharsets.UTF_8);

            Student s = new Student("joao", 0);

            out.println("Hello OutputStream characteres!!!");
            out.println(s);
            out.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}