public class Fracao {
    private int numerador;
    private int denominador;

    public String toString(){
        return numerador + "/"+ denominador; 

    }

    Fracao(int num){
        numerador = num;
        denominador = 1;
    }

    Fracao(int num, int den){
        int d = mdc(num, den);
        numerador = num/d;
        denominador = den/d;


    }

    private int mdc(int a, int b){
        while(b != 0){
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    public int getDenominador(){
        return denominador;
    }

    public int getNumerador(){
        return numerador;
    }


    public Fracao somaFracao(Fracao f){
        return new Fracao(numerador * f.getDenominador() + f.getNumerador() * denominador, 
        denominador * f.getDenominador());
    }

    public Fracao subFracao(Fracao b){
        return new Fracao(numerador * b.getDenominador() - b.getNumerador() * denominador,
        denominador * b.getDenominador());
    }

    public Fracao multFracao(Fracao c){
        return new Fracao(numerador * c.getNumerador(), denominador * c.getDenominador());
    }

    public static void main(String[] args) {
        Fracao f1 = new Fracao(5,3);
        System.out.println(f1);
        Fracao f2 = new Fracao(30,4);
        System.out.println(f2);
        Fracao f3 = f1.somaFracao(f2);
        System.out.println(f3);
        Fracao f4 = f1.subFracao(f2);
        System.out.println(f4);
        Fracao f5 = f1.multFracao(f2);
        System.out.println(f5);
    }
}
