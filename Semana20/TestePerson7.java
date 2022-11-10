import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;
import java.util.List;
import java.util.function.*;

public class TestePerson7 {
    public static void main(String[] args) {
        ArrayList<Person> pessoas = new ArrayList<>();
        pessoas.add(new Person("Joao", 20));
        pessoas.add(new Person("Jose", 15));
        pessoas.add(new Person("Maria", 18));
        pessoas.add(new Person("Felipe", 22));
        
        pessoas
        .stream()
        .filter( p -> p.getIdade() >= 18 && p.getIdade() <= 20)
        .forEach(p -> System.out.println(p));
    }
}