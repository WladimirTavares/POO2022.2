public class ContaBancariaSimplificada {
    String nomeCorrentista;
    double saldo;
    boolean contaEhEspecial;

    ContaBancariaSimplificada(String nomeCorrentista){
        this.nomeCorrentista = nomeCorrentista;
        this.saldo = 0;
        this.contaEhEspecial = false;
    }

    ContaBancariaSimplificada(String nomeCorrentista, double saldo){
        this.nomeCorrentista = nomeCorrentista;
        this.saldo = saldo;
        this.contaEhEspecial = false;
    }

    ContaBancariaSimplificada(String nomeCorrentista, double saldo, boolean contaEhEspecial){
        this.nomeCorrentista = nomeCorrentista;
        this.saldo = saldo;
        this.contaEhEspecial = contaEhEspecial;
    }

    public String toString(){
        return "nome: " + nomeCorrentista + "\n" 
        + "saldo: " + saldo + "\n" + 
        "ehEspecial: " + (contaEhEspecial ? "sim" : "nao");
    }
    
}
