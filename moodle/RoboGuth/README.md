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

**Explicação**

Inicialmente, o conjunto das palavras válidas 

$S = \{?ba??b\}$.

Contudo, o conjunto possui elementos com ?.


1. Seja x um elemento de $S = \{?ba??b\}$ 
2. Considere $x = ?ba??b$ 
3. A interrogação pode ser substituída por a ou b.
4. Agora, $S = \{aba??b, bba??b\}$
5. Seja x um elemento de S. 
6. Considere $x = aba??b$ 
7. A interrogação só pode ser substituída por b.
8. Agora, $S = \{ abab?b, bba??b\}$
9. Seja x = abab?b um elemento de S. 
10. A interrogação pode ser substituída por a ou  b.
11. Agora, $S = \{ababab, ababbb, bba??b\}$
12. Seja x um elemento de S. 
13. Considere $x = bba??b$
14. A interrogação só pode ser substituída por b.
15. Agora, $S = \{ababab, ababbb, bbab?b\}$
16. Seja x um elemento de S. 
17. Considere $x = bbab?b$
18. A interrogação pode ser substituída por a ou  b.
19. Agora, $S = \{ababab, ababbb, bbabab, bbabbb\}$


Dica: Você pode usar um Collections.TreeSet para guardar os elementos de S. Quando um elemento de S não tem interrogação, ele é mantido no conjunto. Quando um elemento de S não tem interrogação, ele é removido e as substituições são realizadas.





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

Você pode utilizar uma coleção de objetos que armazena os elementos de maneira ordenada.

Para gerar todas as palavras válidas, você pode fazer um algoritmo iterativo que gera iterativamente todo o conjunto de palavras válidas.

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


