import java.util.Scanner;

public class plano {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int cota = sc.nextInt();
        int nmes = sc.nextInt();
        
        int consumo = 0;

        for(int i = 0; i<nmes; i++){
            consumo += sc.nextInt();
        }

        System.out.println((cota * nmes-consumo) + cota);
    }
}
