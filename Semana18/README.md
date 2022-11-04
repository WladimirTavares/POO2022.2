## Interface Gráfica com o Usuário


Os conceitos da programação orientada a objetos como: Herança, Polimorfismo e sobrecarga são essenciais para o desenvolvimento de programa com interface gráfica com o usuário (GUI).

Histórico:

**AWT (Abstract Window Toolkit)**

* API padrão para criação de componentes GUI no início da plataforma
Java (entre 1995 até 1998);
* Os objetos AWT são construídos sobre objetos de código nativo do
Sistema Operacional em uso;
* Os componentes GUI originais do pacote java.awt estão diretamente
associados com as capacidades de GUI da plataforma local.
* Os componentes são exibidos com uma aparência diferente em cada plataforma. Por exemplo, de Windows, Apple Macintosh, Solaris, etc.

**Swing**

* API escrita puramente em Java (padrão desde 1998);
* JLabel, JButton, JTextField, etc, são componentes GUI do pacote
javax.swing.
* Mais flexível que o java.awt porque é implementada toda em Java, enquanto que java.awt é implementada em código nativo.

![](GUI1.png)

<p align = "center">
<b>Hierarquia de Classes</b> 
</p>

**Classe abstrata java.awt.Component**

Um componente é um objeto que possui uma representação gráfica que pode ser exibida na tela e que pode interagir com o usuário. Exemplos de componentes são os botões, caixas de seleção e barras de rolagem de uma interface gráfica de usuário típica.

**Classe  java.awt.Container**

Um objeto container genérico do Abstract Window Toolkit(AWT) é um componente que pode conter outros componentes AWT.

Os containers podem ser divididos em vários níveis:
* Nível mais alto: frames, diálogos;
* Nível intermediário: panel, scroll panel
* Nível mais baixo: Button, Label, TextField

Todo programa que usa uma GUI Swing tem pelo menos um container de alto nível (top-level).

Um container de alto nível provê o suporte que os componenetes necessitam para realizar o desenho da tela e o tratamento de eventos.

A linguagem Java fornece alguns containers de alto nível :
* JFrame (Janela principal)
* JDialog (Janela secundária)

**javax.swing.JFrame**

Uma versão estendida de java.awt.Frame que adiciona suporte para a arquitetura de componentes JFC/Swing.

Possui diversos métodos herdados  java.awt.Component, java.awt.Container, java.awt.Frame e class java.awt.Window


```Java
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GUI1 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Primeiro programa");
        JLabel label = new JLabel("Hello World");
        frame.setSize(800,500);
        frame.getContentPane().add(label);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
```


<p align="center">
<img src="GUI2.png">
</p>


<p align = "center">
<b>Primeira Janela</b> 
</p>


**Classe javax.swing.JComponent**

A class javax.swing.JComponent herda de java.awt.Container.

A classe base para todos os componentes Swing , exceto contêineres de alto nível. Para usar um componente que herda de JComponent, você deve adicionar o componente em um container de nível superior.

Subclasses diretas conhecidas: 
``AbstractButton, BasicInternalFrameTitlePane, Box, Box.Filler, JColorChooser, JComboBox, JFileChooser, JInternalFrame, JInternalFrame.JDesktopIcon, JLabel, JLayer, JLayeredPane, JList, JMenuBar, JOptionPane, JPanel, JPopupMenu, JProgressBar, JRootPane, JScrollBar, JScrollPane, JSeparator, JSlider, JSpinner, JSplitPane, JTabbedPane, JTable, JTableHeader, JTextComponent, JToolBar, JToolTip, JTree, JViewport``


**Controles Básicos**

![](basicos.png)

**Controles com informações formatadas**

![](formata.png)

**Controles com informações não-editáveis**

![](nao%20editaveis.png)


**Classe javax.swing.JOptionPane**



JOptionPane facilita a exibição de uma caixa de diálogo padrão que solicita aos usuários um valor ou os informa sobre algo.

```Java
import javax.swing.JOptionPane;

public class GUI2 {
    public static void main(String[] args) {
        String s1 = JOptionPane.showInputDialog("Entre com um número:");
        String s2 = JOptionPane.showInputDialog("Entre com um número:");

        int n1 = Integer.parseInt(s1);
        int n2 = Integer.parseInt(s2);

        JOptionPane.showMessageDialog(null, "A soma dos dois números é " + (n1 + n2), "Resultado", JOptionPane.PLAIN_MESSAGE);
        
        
    }
}
```



<p align="center">
<img src="GUI3.png">
</p>
<p align = "center">
<b>ShowInputDialog</b> 
</p>



<p align="center">
<img src="GUI4.png">
</p>
<p align = "center">
<b>ShowMessageDialog</b> 
</p>


**Estendendo JFrame**

```Java
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.BoxLayout;

public class GUI3 extends JFrame {
    private JLabel label1;
    private JTextField textfield1;
    private JLabel label2;
    private JTextField textfield2;
    private JButton button1;     
    private JLabel label3;
    private JTextField textfield3; 

    public GUI3() {
        super("Somando números");
        
        label1 = new JLabel("Entre com um número");;
        textfield1 = new JTextField(10);
        label2 = new JLabel("Entre com um número");
        textfield2 = new JTextField(10);
        button1 = new JButton("OK");
        label3 = new JLabel("Resultado: ");
        textfield3 = new JTextField(10);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        add(label1);
        add(textfield1);
        add(label2);
        add(textfield2);
        add(button1);
        add(label3);
        add(textfield3);
    }

}

```

**Instaciando minha Janela**
```Java
import javax.swing.JFrame;

public class TesteGUI3 {
    public static void main(String[] args) {

        GUI3 frame = new GUI3();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(275, 180); // configura tamanho do frame
        frame.setVisible(true); // exibe frame
    }
}

``` 

<p align="center">
<img src="GUI5.png">
</p>
<p align = "center">
<b>Estendendo JFrame</b> 
</p>