# Introdução à Linguagem Java

### Primeiro Programa

```Java
// Primeiro programa em Java
public class PrimeiroPrograma {
    public static void main(String[] args) {
        System.out.println("O primeiro de muitos");
    }
}
```

### Convenção de nomes de variáveis


```Java
/*
Convenção de nomes das variáveis
*/

public class Programa03 {
    public static void main(String[] args) {
        int diasDaSemana;
        diasDaSemana = 7;
        System.out.println("Dias: " + diasDaSemana);

        int meses = 12;
        System.out.println("Meses: " + meses);
    }
}
```

### Declaração de constantes 

```Java
/*
Declaração de constantes
*/

public class Programa04 {
  public static void main(String[] args) {
    final double CM_POR_POLEGADA = 2.54; // uma constante
    double larguraPapel = 8.5;
    double alturaPapel = 11;
    System.out.println("Tamanho do papel em centimetros: "
        + larguraPapel * CM_POR_POLEGADA + " por " 
        + alturaPapel * CM_POR_POLEGADA);
  }
}
```

### Tipagem forte da linguagem

```Java
/*
Uma conversão de alargamento transforma
um valor para um tipo que pode incluir, pelo
menos, aproximações de todos os valores do
original
– int para float
*/

public class Programa05 {
    public static void main(String[] args) {
        int n = 123456789;
        System.out.println(n);
        float f = n;            // f = 1.234567892E8
        System.out.println(f);
    }
}
```


```Java
/*
Uma conversão de estreitamento transforma
um valor para um tipo que não pode
armazenar todos os valores do tipo original
– float para int

Java não permite conversão por estreitamento diretamente

*/

public class Programa06 {
    public static void main(String[] args) {
        double pi = 3.1415;
        int p = pi;    // erro de compilacao
        float q = pi;  // erro de compilacao
        System.out.println(q);
        System.out.println(p);
    }
}
```

### System.out.println

```Java
public class Programa08 {
    public static void main(String[] args) {
        double a = 10, b = 7;
        double aux = a/b;
        System.out.println(aux);
        System.out.printf("aux: %f%n", aux);
        System.out.printf("aux: %+f%n", aux);
        System.out.printf("aux: %f%n", aux);
        System.out.printf("aux: %010.2f%n", aux);
        System.out.printf("aux: %10.2f%n", aux);
    }
}
```


### Leitura de Dados o Scanner

```Java
import java.util.Scanner;

public class Programa07 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    System.out.print("Qual eh o seu nome? ");
    String nome = input.nextLine();

    System.out.print("Quantos anos voce tem? ");
    int idade = input.nextInt();

    System.out.println("Ola, " + nome +
        ". Proximo ano, voce tera " +
        (idade + 1) + " anos");

    input.close(); // fecha o Scanner
  }
}
```

### Estruturas Condicionais

```Java
int c = 67;

if(c == 1) { // if
    System.out.println("igual a 1");
} /*L\pauseL*/

if(c == 2) { // if .. else
    System.out.println("igual a 2");
} else {
    System.out.println("nao eh 1 nem 2");
} /*L\pauseL*/

if(c == 3) { // if .. else if .. else
    System.out.println("igual a 3");
} else if(c == 4) {
    System.out.println("igual a 4");
} else {
    System.out.println("nao eh 1,2,3,4");
}
```

### Switch

```Java
Scanner in;
in = new Scanner(System.in);
int opcao = in.nextInt();

switch (opcao) // char,byte,short 
{              // int,String,enum
    case 1:
        // comandos aqui
        break;
    case 2:
        // comandos aqui
        break;
    case 3:
        // comandos aqui
        break;
    default:
        // comandos aqui
        break;
}
```

### while, do while e for

```Java
int contador = 0;

while (contador < 10) {
  System.out.println(count);
  count++;
}

int contador = 0;

do {
  System.out.println(contador);
  contador++;
} while (contador < 10);

for (int i = 0; i < 10; i++)
    System.out.println(i);
```

### Declarando um array

```Java
public class Programa13 {
    public static void main(String[] args) {
        // Declarando array e inicializando
        int[] array = new int[10];

        System.out.printf("%s%8s%n", "Indice", "Valor");

        for(int c = 0; c < array.length; c++) {
            System.out.printf("%6d%8d%n", c, array[c]);
        }
    }
}
```

```Java
public class Programa14 {
  public static void main(String[] args) {
    // Declarando array e inicializando
    int[] array = {32, 27, 64, 18, 95, 14, 90, 70, 60, 37};

    System.out.printf("%s%8s%n", "Indice", "Valor");

    for(int c = 0; c < array.length; c++) {
      System.out.printf("%6d%8d%n", c, array[c]);
    }
  }
}
```


## Exercícios

### Problema Garçom

Descrição do problema: [Garçom](https://olimpiada.ic.unicamp.br/pratique/pj/2010/f1/garcom/)

```Java
/*
*Problema Garçom
https://olimpiada.ic.unicamp.br/pratique/pj/2010/f1/garcom/
*/

import java.util.Scanner;

public class garcom {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int quebrados = 0;
        int latas, copos;
        for(int i = 0; i < n; i++){
            latas = sc.nextInt();
            copos = sc.nextInt();
            if(latas > copos){
                quebrados += copos;
            }
        }
        System.out.println(quebrados);
    } 
}
```
### Problema Fila

Descrição: [Problema Fila](https://olimpiada.ic.unicamp.br/pratique/pj/2014/f1/fila/
)

```Java
/*
Problema Fila
https://olimpiada.ic.unicamp.br/pratique/pj/2014/f1/fila/
*/
import java.util.Scanner;

public class fila {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt(); // n de pessoas
        int[] fila = new int[n];

        for(int i=0; i<n; i++) { // recebe codigo das pessoas
            fila[i] = input.nextInt();
        }

        // vetor de saidas
        int m = input.nextInt();
        int[] saidas = new int[m];

        for(int j=0; j<m; j++) { // recebe codigo das saidas
            saidas[j] = input.nextInt();
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(fila[i] == saidas[j]) {
                    fila[i] = -1;
                    break;
                }
            }
        }

        for(int i=0; i<n; i++) {
            if(fila[i] >= 0) {
                System.out.print(fila[i]+" ");
            }
        }
    } 
}
```


### Problema OBI

Descrição: [Problema OBI](https://olimpiada.ic.unicamp.br/pratique/pj/2008/f1/obi/)
```Java
import java.util.Scanner;

public class obi {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);      
    int N, P;
    N = sc.nextInt();
    P = sc.nextInt();

    int cnt = 0;
    for(int i = 0; i < N; i++){
      int f1, f2;
      f1 = sc.nextInt();
      f2 = sc.nextInt();
      if( f1 + f2 >= P) cnt++;
    }

    System.out.println(cnt);
  }
}
```


### Problema Camisetas

```Java
import java.util.Scanner;

public class camisetas {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);      
    int N;
    N = sc.nextInt();
    int cp = 0;
    int cm = 0;
    for(int i = 0; i < N; i++){
      int T = sc.nextInt();
      if(T == 1) cp++;
      else cm++;
    }
    int P = sc.nextInt();
    int M = sc.nextInt();

    if( cp >= P && cm >= M)
        System.out.println("S");
    else
        System.out.println("N");
       
    }
}
```

### Saldo do Vovô

Descrição: [Saldo do vovô](https://olimpiada.ic.unicamp.br/pratique/pj/2013/f1/saldo/)
```Java
/*
Link: https://olimpiada.ic.unicamp.br/pratique/pj/2013/f1/saldo/
*/
import java.util.Scanner;

public class saldo {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        int menorSaldo = s;

        for (int i = 0; i < n; i++) {
            int mov = sc.nextInt();
            s = s + mov;
            if (s < menorSaldo) {
                menorSaldo = s;
            }
        }

        System.out.println(menorSaldo);
    }
}
```