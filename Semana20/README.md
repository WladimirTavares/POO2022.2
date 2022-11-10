## Expressões Lambdas

As expressões lambda foram adicionadas na linguagem Java para fornecer algumas funcionalidades interessantes:

* Permitir passar uma funcionalidade como um argumento de um método.
* Criar uma função sem precisar criar uma classe.
* Uma expressão lambda pode ser passada como se fosse um objeto e executada sob demanda


## Interface Comparator

Considere o seguinte exemplo:

```Java
public class Person {
    private String nome;
    private int idade;

    public Person(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "Person [nome=" + nome + ", idade=" + idade + "]";
    }
}
```

Você tem uma lista de pessoas que você que ordenar pela idade. O método sort da classe Collections ordena uma lista específica de acordo com uma ordem induzida por um Comparator especificado da seguinte maneira:

```Java
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

class ComparaPorIdade implements Comparator<Person> {
    public int compare(Person p1, Person p2){
        return p1.getIdade() - p2.getIdade();
    }
}

public class TestePerson {
    public static void main(String[] args) {
        
        ArrayList<Person> pessoas = new ArrayList<>();
        pessoas.add( new Person("Joao", 20));
        pessoas.add( new Person("Jose", 15));
        pessoas.add( new Person("Maria", 18));
        pessoas.add( new Person("Felipe", 22));
        Collections.sort( pessoas , new ComparaPorIdade() );
        for(Person p : pessoas){
            System.out.println(p);
        }
    }
}
```


Neste exemplo, precisamos criar uma classe ComparaPorIdade que implementa a interface Comparator<Person> para definir a funcionalidade de comparação entre dois objetos Person. 

Para este exemplo, você pode utilizar uma classe anônima. As classes anônimas podem ser utilizadas quando você quer passar uma funcionalidade de uma classe para um método sem precisar declarar explicitamente essa classe.

```Java
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

public class TestePerson2 {
    public static void main(String[] args) {

        ArrayList<Person> pessoas = new ArrayList<>();

        pessoas.add(new Person("Joao", 20));
        pessoas.add(new Person("Jose", 15));
        pessoas.add(new Person("Maria", 18));
        pessoas.add(new Person("Felipe", 22));

        Collections.sort(pessoas, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getIdade() - o2.getIdade();
            }
        });

        for (Person p : pessoas) {
            System.out.println(p);
        }

    }
}
```

Contudo, você ainda precisar criar um objeto anônimo e passar essa funcionalidade. As expresões lambdas permitem você executar essa tarefa de uma maneira mais fácil.

```Java
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
```

## Interfaces Funcionais

Uma interface contendo apenas um método abstrato é chamada de interface funcional.

O JDK tem muitas interfaces funcionais. Os mais usados ​​são:

* Interface java.awt.event.ActionListener com um único método abstrato actionPerformed(): usado como manipulador de ActionEvent.
* Interface java.lang.Runnable com o único método abstrato run(): para iniciar um novo thread.
* Interface java.util.Comparator com método abstrato único compare(): usado em Collections.sort() ou Arrays.sort().

Essas interfaces são comumente implementadas em uma classe interna anônima.

## @FunctionalInterface Annotation

A anotação @FunctionalInterface pode ser usada para marcar e informar ao compilador que uma interface contém apenas um método abstrato. Isso é útil para evitar a adição acidental de métodos abstratos extras em uma interface funcional.

**Interface Funcional**

```Java
@FunctionalInterface
public interface HelloFunctionalInterface {
    void sayHello(String name);
}
```

**Classe Anônima** 

```Java
public class TesteHelloInterface {
    public static void main(String[] args) {
        Person p = new Person("João", 15);
        HelloFunctionalInterface h = new HelloFunctionalInterface(){
            public void sayHello(String name){
                System.out.println("Meu nome é: " +  name);
            }
        };
        h.sayHello(p.getNome() );
    }
}
```

**Expressões Lambdas**

```
public class TesteHelloInterface2 {
    public static void main(String[] args) {
        Person p = new Person("João", 15);
        HelloFunctionalInterface h = name -> System.out.println("Meu nome é: " + name);
        h.sayHello(p.getNome());
    }
}
```
## Sintaxe das Expressões Lambdas

A sintaxe é:

```Java
(arguments) -> { body }
```

Por exemplo:

```Java
() -> statement    // No argument and one-statement method body

arg -> statement   // One argument (parentheses can be omitted) and method body 

(arg1, arg2, ...) -> { 
   body-block 
}   // Arguments separated by commas and the block body

(Type1 arg1, Type2 arg2, ...) -> { 
   method-body-block;
   return return-value; 
}   // With arguments and block body
```

## Especificando um critério de busca genérico para uma Classe

Novamente, temos um exemplo com uma interface funcional ``checkPerson`` usada para definir um critério de seleção de uma pessoa. Essa interface está sendo usada no método ``printPessoas``. No primeiro exemplo, estamos usando uma classe anônima para passar a funcionalidade da interface checkPerson.

**Classes Anônimas**

```Java
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;
import java.util.List;

@FunctionalInterface
interface checkPerson {
    boolean teste(Person p);
}

public class TestePerson4 {
    
    public static void printPessoas(List<Person> pessoas, checkPerson t){
        for(Person p : pessoas){
            if( t.teste(p) ){
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

        printPessoas(pessoas, new checkPerson() {
            @Override
            public boolean teste(Person p){
                return p.getIdade() >= 18 && p.getIdade() <= 20;
            }
        });
        

    }
}
```

**Expressões Lambdas**

```Java
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
```

## Interface java.util.Function.Predicate
```Java
@FunctionalInterface
interface Predicate<T> {
    boolean test(T t);
}
```

**Interface Predicate**

```Java
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;
import java.util.List;
import java.util.function.*;

public class TestePerson6 {
    
    public static void printPessoas(List<Person> pessoas, Predicate<Person> pred){
        for(Person p : pessoas){
            if( pred.test(p) ){
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
```
**Usando composição de funções**

```Java
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
```