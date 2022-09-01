/*
 * Problema Escada Rolante
 * https://olimpiada.ic.unicamp.br/pratique/pj/2010/f2/escada/
*/

import java.io.*;
import java.util.Scanner;

public class escada {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));
        
        
        
        int n = Integer.parseInt( br.readLine() );
        int []pessoas = new int[n];
        int t = 0;

        for (int i = 0; i < n; i++) {
            pessoas[i] = Integer.parseInt( br.readLine() );
        }

        for (int i = 0; i < n-1; i++) {
           if (pessoas[i+1] <= pessoas[i] + 10) t += pessoas[i+1] - pessoas[i];
           else t += 10;
        }

        t += 10;

        System.out.println(t);
    }    
}
