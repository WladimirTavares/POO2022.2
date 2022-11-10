import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

class ComparaPorIdade implements Comparator<Person> {
    public int compare(Person p1, Person p2) {
        return p1.getIdade() - p2.getIdade();
    }
}

public class TestePerson1 {
    public static void main(String[] args) {

        ArrayList<Person> pessoas = new ArrayList<>();

        pessoas.add(new Person("Joao", 20));
        pessoas.add(new Person("Jose", 15));
        pessoas.add(new Person("Maria", 18));
        pessoas.add(new Person("Felipe", 22));

        Collections.sort(pessoas, new ComparaPorIdade());

        for (Person p : pessoas) {
            System.out.println(p);
        }

    }
}
