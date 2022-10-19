import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Exemplo10 {
    public static void main(String[] args) {
        Queue<Integer> q = new PriorityQueue<Integer>();

        q.add(8);
        q.add(9);
        q.add(10);
        q.add(7);
        
        System.out.println("Iterating over queue");
        Iterator it = q.iterator();
        while( it.hasNext() ){
            System.out.println( it.next() );
        }

        System.out.println("Retrieve elements from priority queue");
        while( !q.isEmpty() ){
            int u = q.poll(); // recupera e remove o primeiro
            System.out.println(u);
        }

    }
}
