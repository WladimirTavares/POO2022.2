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
