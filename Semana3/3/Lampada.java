import java.net.ContentHandler;

public class Lampada {
    boolean estadoDaLampada = false;
    int contadorVezesLigada = 0;
    String local;

    Lampada(String local){
        this.local = local;
    }

    void muda(){
        // estadoDaLampada e o método muda estão na mesma classe
        estadoDaLampada = !estadoDaLampada;
        // contadorVezesLigada e o método muda estão na mesma classe
        if(estadoDaLampada) contadorVezesLigada++;
    }

    void info(){
        System.out.println("Status: " + (estadoDaLampada? "ligada" : "desligada" ));
        System.out.println("Contador: " + contadorVezesLigada);
    }

    int numVezesLigada(){
        return contadorVezesLigada;
    }
   
}
