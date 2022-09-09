# Conta Bancária

![](https://github.com/WladimirTavares/POO2022.2/raw/main/moodle/conta%20bancaria/070.png)

[](toc)

- [Conta Bancária](#conta-bancária)
  - [Descrição](#descrição)
  - [Shell](#shell)
  - [Diagrama](#diagrama)
  - [Arquivos](#arquivos)
[](toc)

## Descrição
O sistema deverá:

* Gerenciar várias classes de Conta Bancária.

* Cada conta bancária deverá ter um número, titular e um saldo.

* O número da conta é um valor que será atribuído automaticamente pela classe.

* A conta bancária deve realizar três operações:
  * sacar um valor
  * depositar um valor
  * transferir um valor.
## Shell

```bash
init gustavo
$init gustavo
show 0
$show 0
Nro da conta: 0, Titular: gustavo, Saldo: 0.00
deposita 0 1000
$deposita 0 1000
show 0
$show 0
Nro da conta: 0, Titular: gustavo, Saldo: 1000.00
init pedro
$init pedro
show 1
$show 1
Nro da conta: 1, Titular: pedro, Saldo: 0.00
deposita 1 450
$deposita 1 450
show 1
$show 1
Nro da conta: 1, Titular: pedro, Saldo: 450.00
transfere 0 1 200
$transfere 0 1 200
show 0
$show 0
Nro da conta: 0, Titular: gustavo, Saldo: 800.00
show 1
$show 1
Nro da conta: 1, Titular: pedro, Saldo: 650.00
end
$end
```


```bash
init pedro
$init pedro
deposita 0 1000
$deposita 0 1000
show 0
$show 0
Nro da conta: 0, Titular: pedro, Saldo: 1000.00
saca 0 1200
$saca 0 1200
Conta ficou zerada após o saque 1000.00 reais
show 0
$show 0
Nro da conta: 0, Titular: pedro, Saldo: 0.00
end
$end
```

## Diagrama
![](https://github.com/WladimirTavares/POO2022.2/raw/main/moodle/conta%20bancaria/diagrama.png)

## Arquivos

```Java
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Locale;

class Conta {
    private String titular;
    private int numero;
    private double saldo;
    private static int totalContas = 0;
    
    public Conta(String titular){
    }



    void deposita(double valor){
        
    }

    static void deposita(Conta c, double valor){
        
    }

    boolean saca(double valor){
        
    }

    static void saca(Conta c, double valor){
        
    }

    boolean transfere(Conta c, double valor){
        
    }

    static boolean transfere(Conta origem, Conta destino, double valor){
        
    }
    


    public String toString(){
        return String.format("Nro da conta: %d, Titular: %s, Saldo: %.2f", numero, titular, saldo);
    }

    double getSaldo(){
        
    }
}




class Solver{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Locale.setDefault ( Locale.US ) ;
        
        ArrayList<Conta> contas = new ArrayList<Conta>();

        while(true) {
            String line = scanner.nextLine();
            String ui[] = line.split(" ");
            System.out.println("$" + line);

            if(ui[0].equals("init")) {
                contas.add( new Conta( ui[1] ) );
            } else if(ui[0].equals("end")) {
                break;
            } else if(ui[0].equals("deposita")) {
                int nro = Integer.parseInt(ui[1] );
                double valor = Double.parseDouble(ui[2]);
                Conta.deposita( contas.get(nro),  valor); 
            }else if(ui[0].equals("saca")) {
                int nro = Integer.parseInt(ui[1] );
                double valor = Double.parseDouble(ui[2]);
                Conta.saca( contas.get(nro),  valor); 
            }else if(ui[0].equals("transfere")) {
                int origem = Integer.parseInt(ui[1] );
                int destino = Integer.parseInt(ui[2] );
                double valor = Double.parseDouble(ui[3]);
                Conta.transfere( contas.get(origem), contas.get(destino), valor); 
            } else if(ui[0].equals("show")) {
                int i = Integer.parseInt(ui[1] );
                System.out.println( contas.get(i) ); 
            } else{
                System.out.println("fail: comando invalido");
            }
        }
        scanner.close();
    }
}

```
