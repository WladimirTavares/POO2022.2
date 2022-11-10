import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;
import java.util.List;

@FunctionalInterface
interface checkPerson {
    boolean teste(Person p);
}

public class TestePerson5 {

    public static void printPessoas(List<Person> pessoas, checkPerson t) {
        for (Person p : pessoas) {
            if (t.teste(p)) {
                System.out.println(p);
            }
        }
    }

    public static void main(String[] args) {

        ArrayList<Person> pessoas = new ArrayList<>();

        pessoas.add(new Person("Joao", 20));
        pessoas.add(new Person("Jose", 15));
        pessoas.add(new Person("Maria", 18));
        pessoas.add(new Person("Felipe", 22));

        printPessoas(pessoas, 
            (Person p) -> p.getIdade() >= 18 && p.getIdade() <= 20
        );

    }
}