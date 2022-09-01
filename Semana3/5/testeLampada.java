

public class testeLampada {
    public static void main(String[] args) {
        Lampada l1 = new Lampada("cozinha");
        System.out.println( l1.getClass() );
        System.out.println( l1.hashCode() );
        System.out.println( l1.toString() );
        System.out.println(l1);
        
    }
}
