public class TesteFracao {
    public static void main(String[] args) {
        Fracao f1 = new Fracao(5,3);
        System.out.println(f1);
        Fracao f2 = new Fracao(30,4);
        System.out.println(f2);
        Fracao f3 = f1.somaFracao(f2);
        System.out.println(f3);
        Fracao f4 = f1.subFracao(f2);
        System.out.println(f4);
        Fracao f5 = f1.multFracao(f2);
        System.out.println(f5);
    }
}
