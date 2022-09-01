import java.util.Scanner;




public class volume {
    
    public static class TV{
        private int volume;
        
        TV(int volumeInicial){
            volume = volumeInicial;
        }
    
        void mudaVolume(int alt){
            volume += alt;
            if( volume < 0) volume = 0;
            if( volume > 100) volume = 100;
        }

        int getVolume(){
            return volume;
        }

    }
    
    
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        TV tv = new TV(sc.nextInt());
        
        int quantAlt = sc.nextInt();
        
        for (int i = 0; i < quantAlt; i++){
            tv.mudaVolume( sc.nextInt() );
        }

        System.out.println( tv.getVolume() );
    }
}
