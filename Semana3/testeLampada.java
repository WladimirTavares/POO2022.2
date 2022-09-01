

public class testeLampada {
    public static void main(String[] args) {
        Lampada l1 = new Lampada();
        l1.acende();
        l1.apaga();
        l1.acende();
        l1.apaga();

        l1.mostra();
        System.out.println( l1.numVezesLigada() );
        
        
    }
}
