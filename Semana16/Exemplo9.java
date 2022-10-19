import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;

public class Exemplo9 {
    public static void main(String[] args) {
        Queue<Integer> q = new ArrayDeque<Integer>();

        q.add(8);
        q.add(9);
        q.add(10);
        q.add(7);

        
        Iterator it = q.iterator();

        while( it.hasNext() ){
            System.out.println( it.next() );
        }

        while( !q.isEmpty() ){
            int u = q.poll(); // recupera e remove o primeiro
            System.out.println(u);
        }

    }
}
