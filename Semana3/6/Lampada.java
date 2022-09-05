
public class Lampada {
    boolean estadoDaLampada = false;
    int contadorVezesLigada = 0;
    String local;

    Lampada(String local){
        //Para acessar a variável local que pertence ao objeto
        // utilizaremos a referência para o objeto que chamou o método
        // através da palavra reservada this.
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
        System.out.println("Local: " + local);
        System.out.println("Contador: " + contadorVezesLigada);
    }
    
    public String toString(){
        return String.format("Status: %s\nLocal: %s\nContador: %d\n", 
        (estadoDaLampada? "ligada" : "desligada" ), local, contadorVezesLigada
        );
    }

    int numVezesLigada(){
        return contadorVezesLigada;
    }
   
}
