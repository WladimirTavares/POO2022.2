

public class testeLampada {
    public static void main(String[] args) {
        Lampada l1 = new Lampada();
        l1.muda();
        l1.muda();
        l1.muda();
        System.out.println(l1.estadoDaLampada);
        System.out.println(l1.contadorVezesLigada); 
    }
}
