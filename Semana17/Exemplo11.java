import java.util.Scanner;
import java.util.regex.*;
public class Exemplo11 {
    public static void main(String[] args) {
        String input = "asfjhfsajfhaskjfsakj asfakjfash 3145.456.856-441.456.789-56 asfkakjfsha askfjajkfsa askjfasjkf asfakjfah";
        Pattern p = Pattern.compile("([0-9]{3}[.]?[0-9]{3}[.]?[0-9]{3}[-]?[0-9]{2})");//. represents single character  
        Matcher m = p.matcher(input);
        
        while (m.find()) {

            //Obtendo o inicio do que foi encontrado
            System.out.println(m.group());
            
         }
        
        
    }
}
