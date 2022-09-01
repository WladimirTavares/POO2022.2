import java.util.Scanner;
import java.util.Arrays;

public class album 
{
    private int N;
    private int M;
    private int [] figurinhas;

    album(int n, int m, int [] a){
        N = n;
        M = m;
        figurinhas = a;
    }

    public int numFigurinhasDiferentes(){

        int count = 1;
        Arrays.sort(figurinhas);
        
        for(int i = 0 ; i < M-1 ; i++)
        {
            if(figurinhas[i] != figurinhas[i+1])
            {
                count ++;
            }    
        }

        return count;
    
    }

    public int quantasFigurinhasFaltam(){
        return N-numFigurinhasDiferentes();
    }


    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[]a = new int[m];
        for(int i = 0; i < m; i++)
        {
            a[i]  = sc.nextInt();
        }

        album A = new album(n, m, a);


        System.out.println(A.quantasFigurinhasFaltam());

        
    }
    
}
