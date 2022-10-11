# Herança

## A superclasse Object
* Toda classe em Java extends a classe java.lang.Object
  * Não precisa herdar explicitamente
* Como toda classe em Java é-um Object, podemos usar uma variável do tipo Object para referenciar objetos de qualquer tipo. Porém, para fazer qualquer coisa especı́fica com o objeto, precisamos saber qual o tipo original do objeto e aplicar um cast:

```Java
Object obj = new Pessoa("Olga");
Pessoa p = (Pessoa) obj;
```

* Em Java, somente os tipos nativos não são objetos.
* Todos os tipos de array, sejam eles arrays de tipos nativos ou de objetos,
são tipos de classes que estendem a classe Object.
```Java
Object obj = new int[10];
obj = new Pessoa[10];
```

## String toString()
* Este método retorna uma string representando o valor do objeto.
* A implementação default desse método retorna o nome do pacote e o
nome da classe do objeto, seguido de @ e de uma representação hexadecimal do valor retornado pelo método hashCode do objeto em questão.
* No entanto, como já vimos, podemos sobrescrever este método na nossa
subclasse para que ele atenda as necessidades da subclasse.


## Class getClass()
* Todo objeto em Java conhece o seu tipo em tempo de execução.
* O método getClass() retorna um objeto da classe Class (pacote
java.lang), que contém informação sobre o tipo do objeto, tal como o
nome da classe.
* Dois dos métodos da classe Class são:
  * String getName(): retorna o nome desta classe.
  * Class getSuperClass(): retorna a superclasse desta classe como um objeto da classe Class.

## boolean equals(Object obj)
* O método equals verifica se dois objetos são iguais e retorna true se e
somente se este for o caso.
* A igualdade que se verifica neste método diz respeito ao conteúdo dos
objetos sendo comparados (se eles possuem ou não o mesmo estado).
* equals recebe qualquer Object como argumento.
* A implementação default do método equals na classe Object usa o
operador de igualdade == para determinar se as duas referências
apontam para o mesmo objeto na memória.
  * Logo, a funcionalidade default deste método geralmente não é adequada e, se quisermos chamar este método em objetos da nossa classe, teremos que sobrescrevê-lo.

## equals() – Superclasses
* Quando você estiver definindo o método equals para uma subclasse,
primeiro chame o método equals da superclasse.
* Se o teste na superclasse não passar, então os objetos não podem ser
iguais.
* Se os atributos da superclasse forem iguais, então você estará pronto para
comparar os atributos da subclasse.

```Java
@Override
public boolean equals(Object obj) {
    if(!super.equals(obj)) return false;

    // super.equals checou que obj pertence
    // à classe Gerente
    Gerente gerente = (Gerente) obj;
    return this.bonus == gerente.bonus;
}
```

##int hashCode()
* Um hash code é um inteiro derivado de um objeto.
  * Se x e y são dois objetos distintos, deve existir uma alta probabilidade de que seus hash codes sejam distintos.
* A implementação default do método hashCode, na classe Object, deriva
o hash code do objeto a partir da sua posição na memória.
* Logo, pela implementação default, dois objetos distintos na memória possuem diferentes hash codes.

## hashCode()
* Algumas classes sobrescrevem o método hashCode de modo que ele
tenha uma lógica diferente.
  * Por exemplo, a classe String calcula o hash code a partir do conteúdo da string. Logo, dois objetos String possuem o mesmo hashCode se e somente suas sequências de caracteres são idênticas.
```Java
public class TesteString {
    public static void main(String[] args) {
        String s = "Ok";
        String t = new String("Ok");

        // No Java, duas Strings possuem o mesmo hashcode se
        // e somente se elas possuem o mesmo conteúdo
        System.out.println(s.hashCode());
        System.out.println(t.hashCode());

        // No Java, duas Strings são iguais se e somente se
        // elas possuem o mesmo conteúdo
        if(s.equals(t)) {
            System.out.println(s + " == " + t);
        } else {
            System.out.println(s + " != " + t);
        }
    }
}
/*
2556
2556
Ok == OK
*/
```
* Porém, outras classes não sobrescrevem o método hashCode.
  *É o caso, por exemplo, da classe StringBuilder
```Java
public class TesteStringBuilder {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Ok");
        StringBuilder tb = new StringBuilder("Ok");

        // A classe StringBuilder não sobrescreve o
        // método hashCode da superclasse Object.
        // Logo, duas referências para StringBuilders 
        // possuem o mesmo hashcode se e somente se elas 
        // apontam para o mesmo objeto na memória
        System.out.println(sb.hashCode());
        System.out.println(tb.hashCode());

        // A classe StringBuilder não sobrescreve o
        // método equals da superclasse Object.
        // Logo, duas StringBulders são iguais se e 
        // somente se elas estão na mesma região da memória
        if(sb.equals(tb)) {
            System.out.println(sb + " == " + tb);
        } else {
            System.out.println(sb + " != " + tb);
        }
    }
}
/*
622488023
1933863327
Ok != Ok
*/
```

## O casamento hashCode() e equals()
* Obs.: se você redefinir o método equals na sua classe, então você deve também redefinir o método hashCode, obedecendo a seguinte regra:
  * Objetos que são iguais de acordo com o método equals devem ter o mesmo hashCode.

## O casamento hashCode() e equals()
* No nosso exemplo, dois objetos x e y não-nulos da classe Empregado são
iguais se e somente se eles possuem o mesmo estado.
Ou seja, se as 3 condições a seguir são satisfeitas:
  * x.nome é igual a y.nome
  * x.salario é igual a y.salario
  * x.dataAdmissao é igual a y.dataAdmissao
* Portanto, os três atributos da classe Empregado devem ser considerados
no cálculo do hashCode de um objeto do tipo Empregado.

```Java
public class Empregado2 {
    private String nome;
    private double salario;
    private LocalDate dataAdmissao;

    public Empregado2(String nome, double salario, int ano, int mes, int dia) {
        this.nome = nome;
        this.salario = salario;
        dataAdmissao = LocalDate.of(ano, mes, dia);
    }

    public String getNome() {
        return nome;
    }

    public double getSalario() {
        return salario;
    }

    public LocalDate getDataAdmissao() {
        return dataAdmissao;
    }

    public void aumentaSalario(double porcentagem) {
        double aumento = salario * porcentagem / 100;
        salario += aumento;
    }

    @Override
    public String toString() {
        String resultado = getClass().getName();
        resultado += "[nome:" + nome + ", salario:" + salario
                + ", data de admissão:" + dataAdmissao + "]";
        return resultado;
    }

    @Override
    public boolean equals(Object obj) {
        // um teste para ver se os objetos são idênticos
        if(this == obj) return true; 
        
        // retorna se false se o argumento é nulo
        if(obj == null) return false;

        // se as classes não casam, não podem ser iguais
        if(this.getClass() != obj.getClass()) return false;

        // agora, sabemos que obj é um Empregado não-nulo
        Empregado2 p = (Empregado2) obj;

        // checa se os estados dos objetos são idênticos
        return this.nome.equals(p.nome)
            && this.salario == p.salario
            && this.dataAdmissao.equals(p.dataAdmissao);
    }
}
```

## O casamento hashCode() e equals()
* A classe Objects (pacote java.util) possui várias versões sobrecarregadas
do método estático hashCode(), que recebe um argumento e retorna o hash code dele. Esse método retorna 0 se o argumento passado para ele for null; caso contrário, ela chama o método hashCode para o argumento e retorna o seu valor.

```Java
import java.time.LocalDate;
import java.util.Objects;

public class Empregado4 {
    private String nome;
    private double salario;
    private LocalDate dataAdmissao;

    public Empregado4(String nome, double salario, int ano, int mes, int dia) {
        this.nome = nome;
        this.salario = salario;
        dataAdmissao = LocalDate.of(ano, mes, dia);
    }

    public String getNome() {
        return nome;
    }

    public double getSalario() {
        return salario;
    }

    public LocalDate getDataAdmissao() {
        return dataAdmissao;
    }

    public void aumentaSalario(double porcentagem) {
        double aumento = salario * porcentagem / 100;
        salario += aumento;
    }

    @Override
    public String toString() {
        String resultado = getClass().getName();
        resultado += "[nome:" + nome + ", salario:" + salario + 
                        ", data de admissão:" + dataAdmissao + "]";
        return resultado;
    }

    @Override
    public boolean equals(Object obj) {
        // um teste para ver se os objetos são idênticos
        if(this == obj) return true; 
        // retorna se false se o argumento é nulo
        if(obj == null) return false;
        // se as classes não casam, não podem ser iguais
        if(getClass() != obj.getClass()) return false;
        // agora, sabemos que obj é um Empregado não-nulo
        Empregado4 p = (Empregado4) obj;
        // checa se os estados dos objetos são idênticos
        return Objects.equals(nome, p.nome)
            && salario == p.salario
            && Objects.equals(dataAdmissao, p.dataAdmissao);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nome) + 
               Objects.hashCode(salario) + 
               Objects.hashCode(dataAdmissao);
    }
}
```