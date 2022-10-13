# Classes Abstratas e Interfaces

## Cenário 1: Formas Geométricas

![](abstrata1.png)

* Queremos guardar uma lista de formas geométricas (cı́rculos, retângulos ou triângulos) para depois imprimir a área e o perı́metro delas.

* As formas geométricas podem ter uma cor associada.

```Java
public static void printAreas(List<Shape> list)
{
    for(Shape figure : list) 
        System.out.println(figure.area());
}

public static void printPerimeters(List<Shape> list)
{
    for(Shape figure : list) 
        System.out.println(figure.perimeter());
}
```

## Observações sobre essa hierarquia de herança
* Obs. 1: Não faz sentido ter um objeto Shape no sistema, já que não
sabemos calcular a área e perı́metro de tal objeto.
* Obs. 2: Não precisamos ter um objeto Shape no sistema. Estamos
usando essa classe apenas para o polimorfismo.
    * Em alguns sistemas, como é neste caso, usamos uma classe com
apenas esse intuito: ganhar polimorfismo para criar métodos mais
genéricos, que se encaixem a diversos objetos.


## Cenário 2: Pessoa fı́sica e Pessoa jurı́dica
* Suponha que, em um negócio relacionado a banco, apenas Pessoa fı́sica e Pessoa jurı́dica são permitidas.
* Imagine a superclasse Pessoa e duas filhas: PessoaFisica e
PessoaJuridica.
* Quando puxamos relatórios de nossos clientes (um ArrayList de Pessoa,
por exemplo), queremos que cada um deles seja ou uma PessoaFisica
ou uma PessoaJuridica.
* A classe Pessoa, neste caso, estaria sendo usada apenas para ganhar o
polimorfismo e herdar algumas coisas: não faz sentido permitir instanciá-la.

## Questionamento
* Se a classe Pessoa não pode ser instanciada, por que simplesmente não
criar somente PessoaFisica e PessoaJuridica?
* Resposta:
    * Reuso
    * Polimorfismo: a superclasse genérica nos permite tratar de forma fácil e uniforme todos os tipos de pessoa, inclusive com polimorfismo se for o caso. Por exemplo, você pode colocar todos tipos de contas em uma mesma coleção.

## Classes abstratas e Interfaces
* A linguagem Java tem dois mecanismos que permitem a criação de tipos
que somente contêm descrições de atributos e métodos que devem ser
implementados, mas sem efetivamente implementar os métodos:
    * Classes abstratas
    * Interfaces

## Métodos abstratos e classes abstratas

* Método abstrato é um método que é declarado com o modificador
abstract e é declarado sem uma implementação.

Exemplo: abstract double area();

*Classes abstratas são classes que não podem ser instanciadas, mas
podem ser herdadas.

*Uma classe abstrata é declarada com o modificador abstract.

* Uma classe abstrata pode ou não ter métodos abstratos. Se ela tiver,
automaticamente é abstrata e deve ser declarada com o modificador
abstract.

* É uma forma de garantir herança total: somente subclasses concretas
podem ser instanciadas, mas nunca a superclasse abstrata.

```Java
public enum Color {
    BLACK, BLUE, RED;
}

public abstract class Shape {
    private Color color;
    public abstract double area();
    public abstract double perimeter();

    public Shape(Color color) { this.color = color; }
    public Color getColor() { return color; }
    public void setColor(Color color) { this.color = color; }
    
    @Override public final String toString() {
        return getClass().getName();
    }
}
```

![](abstrata2.png)

* identificadores de classes e métodos abstratos em itálico.


