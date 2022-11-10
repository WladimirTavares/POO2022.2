public class TesteHelloInterface2 {
    public static void main(String[] args) {
        Person p = new Person("João", 15);
        HelloFunctionalInterface h = name -> System.out.println("Meu nome é: " + name);
        h.sayHello(p.getNome());
    }
}
