import java.util.Scanner;

public class saldo {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        int menorSaldo = s;

        for (int i = 0; i < n; i++) {
            int mov = sc.nextInt();
            s = s + mov;
            if (s < menorSaldo) {
                menorSaldo = s;
            }
        }

        System.out.println(menorSaldo);
    }
}
