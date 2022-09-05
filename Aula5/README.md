# Atributos e métodos estátios

Cada instância de uma dessas classes terá uma cópia de todos os atributos declarados na classe.
* Esses atributos são chamados **atributos de instância**.
* Modificar o valor de um atributo de instância de um objeto não interfere no valor do mesmo atributo em outro objeto da mesma classe.

Os atributos numero, titular e saldo são **atributos de instância**.

```Java
/**
 * A classe Conta modela uma conta bancária simplificada.
 */
public class Conta {
    private int numero;
    private String titular;
    private double saldo;

    /**
     * Construtor que recebe três argumentos. Quando o objeto do 
     * tipo Conta for instanciado com um inteiro, uma String e um 
     * double passados por parâmetro, esse construtor será executado.
     * @param numero número da conta
     * @param titular nome do titular da conta
     * @param saldo saldo da conta
     */
    Conta(int numero, String titular, double saldo) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = saldo;
    }

    /**
     * Construtor que recebe dois argumentos. Quando o objeto 
     * do tipo Conta for instanciado com um inteiro e uma String 
     * passados por parâmetro, esse construtor será executado.
     * @param numero número da conta
     * @param titular nome do titular da conta
     */
    Conta(int numero, String titular) {
        // invoca o construtor com três parâmetros
        this(numero, titular, 0.0); 
    }

    public int getNumero() { // getter
        return numero;
    }

    public double getSaldo() { // getter
        return saldo;
    }

    public String getTitular() { // getter
        return titular;
    }

    /**
     * Método para sacar uma quantia da conta.
     * @param valor o valor a ser sacado da conta
     * @return true se o saque for bem-sucedido, false caso contrário
     */
    public boolean saca(double valor) {
        if(valor >= 0 && valor <= this.saldo) {
            this.saldo -= valor;
            return true;
        }
        else return false;
    }

    /**
     * Método usado para depositar uma quantia na conta.
     * Antes de depositar, verifica se o valor é não-negativo.
     * @param valor quantia a ser depositada na conta
     * @return true se o depósito for bem-sucedido, false caso contrário
     */
    public boolean deposita(double valor) {
        if(valor >= 0) {
            this.saldo += valor;
            return true;
        }
        else return false;
    }

    /**
     * Método que transfere uma quantia desta conta para outra
     * Antes de transferir, verifica se a conta possui a 
     * quantidade a ser transferida disponível.
     * @param destino conta para a qual a quantia deve ser transferida
     * @param valor quantia a ser transferida
     * @return true se a transferência for bem sucedida, false caso contrário
     */
    public boolean transfere(Conta3 destino, double valor) {
        boolean retirou = this.saca(valor);
        if(retirou == false) {
            return false; // não deu para sacar
        }
        else {
            destino.deposita(valor);
            return true;
        }
    }
    
    /**
     * Método toString sobrescrito.
     * @return uma string com a descrição do objeto
     */
    public String toString() {
        String output = this.getClass().getName() + "[" + 
            "número:" + numero + "," +
            "Titular:" + titular + "," + 
            "Saldo:" + saldo + "]";
        return output;
    }
}
```

### Problema

Suponha que o banco quer controlar a quantidade de contas existentes no sistema. Como podemos implementar esse requisito?


Essa informação não pode pertencer a uma única instância da classe Conta.

```
Uma solução elegante seria se pudéssemos ter uma variável
contadora compartilhada por todos os objetos da classe Conta.
Quando um objeto modificasse o valor do contador, o seu novo valor estaria visı́vel e acessı́vel para todos os outros objetos da classe.
```

### Atributos Estáticos

* **Atributos estáticos** são atributos compartilhados por todas as instâncias de uma classe.
*  Em Java, atributos estáticos são declarados com o modificador static, que deve ser declarado antes do tipo de dado do atributo.
private static int totalDeContas;
* Somente um valor é armazenado em um atributo estático, e caso este
valor seja modificado por uma das instâncias da classe, a modificação será
refletida em todas as outras instâncias da classe.

* Atributos estáticos são também conhecidos como atributos de classes, já
que estes atributos poderão ser acessados diretamente usando o nome da
classe, sem que seja necessária a criação de uma instância da classe e
uma referência para esta instância.

```Java
/**
 * A classe Conta modela uma conta bancária simplificada.
 */
public class Conta {
    private int numero;
    private String titular;
    private double saldo;
    private static int contador = 0;

    /**
     * Construtor que recebe três argumentos. Quando o objeto do 
     * tipo Conta for instanciado com um inteiro, uma String e um 
     * double passados por parâmetro, esse construtor será executado.
     * @param numero número da conta
     * @param titular nome do titular da conta
     * @param saldo saldo da conta
     */
    Conta(int numero, String titular, double saldo) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = saldo;
        contador++;
    }

    int getContadorConta(){
        return contador;
    }

    /**
     * Construtor que recebe dois argumentos. Quando o objeto 
     * do tipo Conta for instanciado com um inteiro e uma String 
     * passados por parâmetro, esse construtor será executado.
     * @param numero número da conta
     * @param titular nome do titular da conta
     */
    Conta(int numero, String titular) {
        // invoca o construtor com três parâmetros
        this(numero, titular, 0.0); 
    }

    public int getNumero() { // getter
        return numero;
    }

    public double getSaldo() { // getter
        return saldo;
    }

    public String getTitular() { // getter
        return titular;
    }

    /**
     * Método para sacar uma quantia da conta.
     * @param valor o valor a ser sacado da conta
     * @return true se o saque for bem-sucedido, false caso contrário
     */
    public boolean saca(double valor) {
        if(valor >= 0 && valor <= this.saldo) {
            this.saldo -= valor;
            return true;
        }
        else return false;
    }

    /**
     * Método usado para depositar uma quantia na conta.
     * Antes de depositar, verifica se o valor é não-negativo.
     * @param valor quantia a ser depositada na conta
     * @return true se o depósito for bem-sucedido, false caso contrário
     */
    public boolean deposita(double valor) {
        if(valor >= 0) {
            this.saldo += valor;
            return true;
        }
        else return false;
    }

    /**
     * Método que transfere uma quantia desta conta para outra
     * Antes de transferir, verifica se a conta possui a 
     * quantidade a ser transferida disponível.
     * @param destino conta para a qual a quantia deve ser transferida
     * @param valor quantia a ser transferida
     * @return true se a transferência for bem sucedida, false caso contrário
     */
    public boolean transfere(Conta3 destino, double valor) {
        boolean retirou = this.saca(valor);
        if(retirou == false) {
            return false; // não deu para sacar
        }
        else {
            destino.deposita(valor);
            return true;
        }
    }
    
    /**
     * Método toString sobrescrito.
     * @return uma string com a descrição do objeto
     */
    public String toString() {
        String output = this.getClass().getName() + "[" + 
            "número:" + numero + "," +
            "Titular:" + titular + "," + 
            "Saldo:" + saldo + "]";
        return output;
    }
}
```

Os membros estáticos de uma
classe são indicados
sublinhando os seus nomes no
diagrama de classes UML.
◦ atributos estáticos
◦ métodos estáticos
• Programadores Java traduzem
o sublinhando para a
palavra-chave static.