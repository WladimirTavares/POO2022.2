public class Data {
    
    private int dia;
    private int mes;
    private int ano;

    public int getDia()
    {
        return dia;
    }
    
    public int getMes(){
        return mes;
    }

    public int getAno(){
        return ano;
    }

    public Data(int dia, int mes, int ano){
        if(dataValida(dia, mes)){
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
        }
    }

    public String toString()
    {
        return dia + "/" + mes + "/" + ano;
    }

    private boolean dataValida(int dia, int mes){
        return (dia >= 1 && dia < 32 && mes >= 1 && mes < 13 );
    }
    
}

