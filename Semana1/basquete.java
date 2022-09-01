import java.util.Scanner;

public class basquete {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int distancia = sc.nextInt();

        if(distancia <= 800){
            System.out.println(1);
        }else if(distancia <= 1400){
            System.out.println(2);
        }else{
            System.out.println(3);
        }
    }    
}
