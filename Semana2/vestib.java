import java.util.Scanner;

public class vestib {
    public static void main(String [] args){
        int n;
        String s1, s2;

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        sc.nextLine();
        s1 = sc.nextLine();
        s2 = sc.nextLine();

        int acerto = 0;

        for(int i = 0; i < n; i++){
            if(s1.charAt(i) == s2.charAt(i)){
                acerto++;
            }
        }
        System.out.println(acerto);
    }        
}
