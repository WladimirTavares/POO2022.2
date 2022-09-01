public class Lampada {
    boolean estadoDaLampada = false;
    int contadorVezesLigada = 0;

    void muda(){
        // estadoDaLampada e o método muda estão na mesma classe
        estadoDaLampada = !estadoDaLampada;
        // contadorVezesLigada e o método muda estão na mesma classe
        if(estadoDaLampada) contadorVezesLigada++;
    }
}
