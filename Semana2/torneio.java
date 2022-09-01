import java.util.Scanner;

public class torneio {
   public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String resultado;
        int count= 0;
        int grupo;

        for(int i = 0; i < 6; i++) {
            resultado = sc.next();
            //System.out.println(resultado);
            if(resultado.charAt(0) == 'V') {
                count += 1;
            }    
        }
        grupo = (count >= 5)? 1 : (count >= 3)? 2 : (count >= 1)? 3 : -1;

        System.out.println(grupo);
   } 
}
