import java.util.LinkedHashSet;
import java.util.Iterator;
import java.util.Set;


public class Exemplo5 {
    public static void main(String[] args) {
        Set<Integer> set = new LinkedHashSet<Integer>();

        set.add(4);
        set.add(5);
        set.add(8);
        set.add(9);
        set.add(15);
        set.add(4587861);
        
        set.add(5756);
        set.add(4784);
        set.add(4777);
        
        

        System.out.println( set.size() );

        Iterator it = set.iterator();

        while( it.hasNext() ){
            System.out.println( it.next() );
        }

        
        
        
        
        
    }
}
