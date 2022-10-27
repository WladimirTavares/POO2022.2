# Robo Guth-13

O pequeno robô Guth-13 está explorando ruínas antigas da cidade de Quixadá. Ele encontrou um pedaço de papel com uma palavra escrita nele. Felizmente, as pessoas que viviam neste local há milhares de anos usavam apenas duas letras do alfabeto moderno: 'a' e 'b'. Sabe-se também que nenhuma palavra antiga contém duas letras 'a' seguidas. Guth-13 já reconheceu algumas das letras da palavra, as outras ainda são desconhecidas.

Guth-13 quer listar todas as palavras válidas que poderiam ser escritas neste papel em um dicionário antigo. Ele precisa de sua ajuda. Liste todas as palavras válidas que pode ser escrita no papel em ordem alfabética.

# Entrada
```
?ba??b
```

# Saída

```
ababab
ababbb
bbabab
bbabbb
``` 

# Entrada
```
??a??b
```

# Saída

```
ababab
ababbb
bbabab
bbabbb
``` 


# Guide

Na linguagem Java, a String é imutável para modificar um caractere de uma String, você pode fazer o seguinte:

```Java
char[] chars = p.toCharArray();
chars[2] = 'b';
p = String.valueOf(chars)
``` 

Você utilizar uma coleção de objetos que armazena os elementos ordenados.

Você pode fazer um algoritmo iterativo que gera iterativamente todo o conjunto de palavras válidas.

```Java
//Seja s um conjunto de palavras
//Seja novas um conjunto de palavras
do{
  s = novas
  novas = {}
  Para cada palavra in s
      novas.add (gere_novas_palavras(s))
  
}(novas.size() > s.size());
```

# Solver

```Java
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;


class Robo {
    String palavra;

    public Robo(String palavra) {
        this.palavra = palavra;
    }

    public Collection<String> palavrasValidas(){

    }
    


}

class Solver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        Robo r = new Robo(s);
        for(var palavra : r.palavrasValidas()){
            System.out.println(palavra);
        }

    }   
}
```


