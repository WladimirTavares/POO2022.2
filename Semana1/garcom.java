import java.util.Scanner;

public class garcom {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int quebrados = 0;
        int latas, copos;
        for(int i = 0; i < n; i++){
            latas = sc.nextInt();
            copos = sc.nextInt();
            if(latas > copos){
                quebrados += copos;
            }
        }
        System.out.println(quebrados);
    } 
}
