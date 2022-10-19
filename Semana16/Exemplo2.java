import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class Exemplo2 {
    public static void main(String[] args) {
        Collection<Integer> lista = new HashSet<Integer>();

        lista.add(5);
        lista.add(8);
        lista.add(9);
        lista.add(4);
        lista.add(5);

        Iterator it = lista.iterator();

        while( it.hasNext() ){
            System.out.println( it.next() );
        }

        System.out.println( lista.contains(7) );
    }
}


