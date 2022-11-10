import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

public class TestePerson3 {
    public static void main(String[] args) {

        ArrayList<Person> pessoas = new ArrayList<>();

        pessoas.add(new Person("Joao", 20));
        pessoas.add(new Person("Jose", 15));
        pessoas.add(new Person("Maria", 18));
        pessoas.add(new Person("Felipe", 22));

        Collections.sort(pessoas, 
          (Person o1, Person o2) -> o1.getIdade() - o2.getIdade()    
        );

        for (Person p : pessoas) {
            System.out.println(p);
        }

    }
}
