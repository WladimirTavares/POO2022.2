import java.util.Scanner;

public class campominado {
    public static void main(String[] args) {
        Scanner sf = new Scanner(System.in);
        int tamanho = sf.nextInt();
        int []jogo = new int[tamanho];
        int []vetor = new int[tamanho];
        for(int i = 0; i < tamanho; i++){
            jogo[i] = sf.nextInt();
        }
        if(tamanho == 1){
            vetor[0] = jogo[0];
        }else{
        for(int i = 0; i < tamanho; i++){
            if(i==0){
                vetor[i] = 0;
                vetor[i] =+ jogo[i]+jogo[i+1];
            }else if(i==tamanho-1){
                vetor[i] = 0;
                vetor[i] += jogo[i]+jogo[i-1];
            }else{
                vetor[i] = 0;
                vetor[i] += jogo[i]+jogo[i+1]+jogo[i-1];
            }
        }
    }
        for(int i = 0; i < tamanho; i++){
            System.out.println(vetor[i]);
        }
        
    }
}
