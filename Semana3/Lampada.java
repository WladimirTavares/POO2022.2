public class Lampada {
    boolean estadoDaLampada;
    int numVezes;
    String local;

    Lampada(String l){
        estadoDaLampada = false;
        numVezes = 0;
        local = l;
    }

    void mostra(){
        if(estadoDaLampada){
            System.out.println("a lampada do(a)" + l + "esta acesa");
        }
        else{
            System.out.println("a lampada do(a)" + l + "esta acesa");
        }
    }
    void acende(){
        numVezes++;
        estadoDaLampada = true;
    }

    void apaga(){
        estadoDaLampada = false;
    }

    int numVezesLigada(){
        return numVezes;
    }    

}
