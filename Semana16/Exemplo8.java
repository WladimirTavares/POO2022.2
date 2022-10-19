import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Iterator;

public class Exemplo8 {
    public static void main(String[] args) {
        Map<String, Integer> votos = new LinkedHashMap<String, Integer>();

        votos.put("java", 6);
        votos.put("python", 6);
        votos.put("c++", 5);
        votos.put("javascript", 8);
        votos.put("ada", 1);
        votos.put("c", 3);
        votos.put("bash", 1);
        votos.put("eiffel", 0);
        
        Iterator<Map.Entry<String, Integer>> it = votos.entrySet().iterator();
        System.out.println("iterating using Iterator");
        
        //using Iterator
        while( it.hasNext() ){
            Map.Entry<String, Integer> entry = it.next(); 
            System.out.printf( "votos[%s] = %d\n", entry.getKey(), entry.getValue() );
        }
        System.out.println("iterating using Iterator + type inference");
        
        //using Iterator + type inference
        var it2 = votos.entrySet().iterator();
        while( it2.hasNext() ){
            var entry = it2.next(); 
            System.out.printf( "votos[%s] = %d\n", entry.getKey(), entry.getValue() );
        }
        System.out.println("iterating over entrySet");
        //iterating over entrySet
        for(var entry : votos.entrySet() ){
            System.out.printf( "votos[%s] = %d\n", entry.getKey(), entry.getValue() );
        }
        System.out.println("iterating over keySet");
        //iterating over keySet
        for(String key : votos.keySet() ){
            System.out.printf( "votos[%s] = %d\n", key, votos.get(key) );
        }

        System.out.println("iterating using forEach");
        //iterating using forEach
        votos.forEach( (k,v)-> System.out.printf( "votos[%s] = %d\n", k, v) );

        
    }
}
