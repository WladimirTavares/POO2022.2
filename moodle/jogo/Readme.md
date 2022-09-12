# Jogo de Tabuleiro

![](https://github.com/WladimirTavares/POO2022.2/raw/main/moodle/jogo/003.png)

[](toc)

- [Jogo de Tabuleiro](#jogo-de-tabuleiro)
  - [Descrição](#descrição)
  - [Diagrama](#diagrama)
  - [Shell](#shell)
  - [Esqueleto](#esqueleto)
[](toc)

## Descrição
Nosso jogo consiste em um tabuleiro contendo uma trilha de quadrados e um conjunto de peças coloridas. No início do jogo, cada jogador recebe uma peça; todas as peças são inicialmente posicionadas logo antes da primeira casa da trilha.

O jogo prossegue em rodadas. Em cada rodada, os jogadores rolam um par de dados e movem suas peças para frente um número de quadrados igual ao resultado obtido pelos dados. Os jogadores rolam os dados sempre na mesma ordem (jogador A, depois jogador B, etc.) nas rodadas.
A maioria dos quadrados no tabuleiro são quadrados simples, mas alguns são “armadilhas”. Se a peça de um jogador cair em um quadrado da armadilha no final do movimento do jogador, o jogador perde a próxima rodada. Ou seja, ela/ele não jogue os dados, e sua peça fica uma rodada sem se mover.

Haverá exatamente três armadilhas na trilha.

O vencedor do jogo é o jogador cuja peça chega primeiro ao final da trilha. O fim da trilha é depois da última casa do tabuleiro. Considere, por exemplo, a placa da figura acima, que tem quadrados numerados de 1 a 48. No início, as peças são posicionadas no local marcado como 'Início', ou seja, antes do quadrado número 1. Portanto, se um jogador rolar um 7 (dados mostrando 2 e 5
por exemplo), sua peça é posicionada na casa número 7 no final da primeira rodada do jogo.
Além disso, se a peça de um jogador estiver posicionada na casa 41, o jogador precisa de um resultado de rolagem de pelo menos 8 para
chegar ao final da trilha e ganhar o jogo.Observe também que não haverá empate no jogo.


## Diagrama
![](https://github.com/WladimirTavares/POO2022.2/raw/main/moodle/jogo/diagrama.png)


## Shell

```bash
$init 2 10
$addArmadilha 2
$addArmadilha 4
$addArmadilha 8
$show
PosJogador[1] = 0
PosJogador[2] = 0

$addMove 1 1
O jogador 1 vai para a casa 2
O jogador 1 caiu em um armadilha
$addMove 3 4
O jogador 2 vai para a casa 7
$addMove 1 2
O jogador 1 passa a vez
O jogador 2 vai para a casa 10
$addMove 6 5
O jogador 1 vai para a casa 13
O jogador 1 venceu o jogo
show
$show
PosJogador[1] = 13
PosJogador[2] = 10

$addMove 3 7
O jogo acabou
$end
```


## Esqueleto
<!--FILTER Solver.java java-->
```java
import java.util.Scanner;
import java.util.Locale;


class Jogo{
    
    private int numJogadores;
    private int [] armadilha;
    private int [] posicao;
    private boolean [] podeJogar;
    private int numArmadilha = 0;
    private int numCasas;
    private int prox;
    private boolean fimDoJogo = false;
    
    public Jogo(int numJogadores, int numCasas){
        
    }
    
    public void addArmadilha(int t){
        
    }
    
    public void addMove(int d1, int d2){
        
    }
    public String toString(){
        
    }
    
}



class Solver{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Locale.setDefault ( Locale.US ) ;
        Jogo jogo = new Jogo(0,0);

        while(true) {
            String line = scanner.nextLine();
            String ui[] = line.split(" ");
            System.out.println("$" + line);
            if(ui[0].equals("init")) {
                jogo = new Jogo( Integer.parseInt( ui[1]),  Integer.parseInt( ui[2]) );
            } else if(ui[0].equals("end")) {
                break; 
            } else if(ui[0].equals("addArmadilha")) {
                jogo.addArmadilha( Integer.parseInt( ui[1]) ); 
            } else if(ui[0].equals("addMove")) {
                int d1 = Integer.parseInt( ui[1]);
                int d2 = Integer.parseInt( ui[2]);
                jogo.addMove(d1, d2);
            } else if(ui[0].equals("show")) {
                System.out.println(jogo);
            }else{
                System.out.println("fail: comando invalido");
            }
        }
        scanner.close();
    }
}

```
<!--FILTER_END-->