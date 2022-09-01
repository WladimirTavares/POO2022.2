import java.util.Scanner;

public class fila {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt(); // n de pessoas
        int[] fila = new int[n];

        for(int i=0; i<n; i++) { // recebe codigo das pessoas
            fila[i] = input.nextInt();
        }

        // vetor de saidas
        int m = input.nextInt();
        int[] saidas = new int[m];

        for(int j=0; j<m; j++) { // recebe codigo das saidas
            saidas[j] = input.nextInt();
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(fila[i] == saidas[j]) {
                    fila[i] = -1;
                    break;
                }
            }
        }

        for(int i=0; i<n; i++) {
            if(fila[i] >= 0) {
                System.out.print(fila[i]+" ");
            }
        }
    } 
}
