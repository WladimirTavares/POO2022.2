# Gerenciando de Figuras


[](toc)

- [Gerenciando de Figuras](#gerenciando-de-figuras)
  - [Intro](#intro)
  - [Guide](#guide)
  - [Shell](#shell)
  - [Esqueleto](#esqueleto)
[](toc)

## Intro

Faça um programa para gerenciar figuras geométricas. Para cada figura geométrica, podemos calcular a área, o perímetro e checar se uma ponto está dentro ou não da figura geométrica.   


As figuras geométricas podem ser círculos ou retângulos.

O retângulo é definido por dois pontos: o ponto inferior esquerdo e o ponto superior direito.

O círculo pode ser definido pelo ponto do centro e pelo raio. 




***
## Guide
![](https://raw.githubusercontent.com/WladimirTavares/POO2022.2/main/moodle/Figuras/diagrama.png)


***
## Shell


```sh
circulo 2 3 5
$circulo 2 3 5
area
$area
area total: 78.54
perimetro
$perimetro
perimetro total: 31.42
inside 1 1
$inside 1 1
true
retangulo 1 1 3 3 
$retangulo 1 1 3 3 
area
$area
area total: 82.54
perimetro
$perimetro
perimetro total: 39.42
inside 2 2
$inside 2 2
true
true
inside 3 3
$inside 3 3
true
true
inside 4 4
$inside 4 4
true
false
end
$end

```

## Esqueleto 

```Java
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class App {
    
    public static void main(String[] args) {
        ArrayList<Shape> lista = new ArrayList<Shape>();
        Scanner sc = new Scanner(System.in);
        while(true){
            String line = sc.nextLine();
            System.out.println("$" + line);
            String ui[] = line.split(" ");
            if(line.equals("end")) {
                break;
            } else if(ui[0].equals("circulo")) {
                double x = Double.parseDouble(ui[1]);
                double y = Double.parseDouble(ui[2]);
                double r = Double.parseDouble(ui[3]);
                Ponto2D pc = new Ponto2D( x, y);
                

            } else if(ui[0].equals("retangulo")) {
                double x1 = Double.parseDouble(ui[1]);
                double y1 = Double.parseDouble(ui[2]);
                double x2 = Double.parseDouble(ui[3]);
                double y2 = Double.parseDouble(ui[4]);
                
                
            } else if(ui[0].equals("area")) {
                
            } else if(ui[0].equals("perimetro")) {//value value
                
            } else if(ui[0].equals("inside")) {//value value
                
                
            } else if(ui[0].equals("mostra")) {//value value
                

            }
            else {
                System.out.println("fail: comando invalido");
            }
        }
        sc.close();
        


    }

}
```