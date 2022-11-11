import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Board {
    int rows;
    int cols;
    Cell [][] cells;
    int encontradas;

    Board(){
        try{
            InputStream is = new FileInputStream("input.in");
            BufferedReader br = new BufferedReader( new InputStreamReader(is) );
            int n = Integer.parseInt(br.readLine());
            System.out.println(n);
            rows = n;
            cols = n;
            cells = new Cell[n][n];
            encontradas = 0;
            for(int i = 0; i < n; i++){
                String line = br.readLine();
                for(int j = 0; j < n; j++){   
                    switch( line.charAt(j)){
                        case 'B':
                            cells[i][j] = new Cell(i,j,Color.BLACK);
                            encontradas++;
                            break;
                        case 'W':
                            cells[i][j] = new Cell(i,j,Color.WHITE);
                            encontradas++;
                            break;
                        case 'G':
                            cells[i][j] = new Cell(i,j,Color.GRAY);
                            break;
                        
                        default:
                            break;
                    }
                }
            }   
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    


    public int getEncontradas() {
        return encontradas;
    }

    public boolean isFixed(int row, int col){
        return cells[row][col].isFixed();
    }

    void setColor(int row, int col, Color color){
        cells[row][col].setColor(color);
    }

    boolean isValidMove(int row, int col, Color color){
        

        if( col-1 >= 0 && col+1 < rows){
            String s = String.format("row col-1 %s %s %s", 
            cells[row][col-1].getColor(),
            cells[row][col].getColor(),
            cells[row][col+1].getColor() 
            ); 
            JOptionPane.showMessageDialog(null, s);

            if( cells[row][col-1].getColor() == color && cells[row][col+1].getColor() == color){
                return false;
            }
        }

        if( col+2 < rows){ 
            String s = String.format("row col %s %s %s", 
            cells[row][col].getColor(),
            cells[row][col+1].getColor(),
            cells[row][col+2].getColor() 
            );
            
            JOptionPane.showMessageDialog(null, s);            


            if( cells[row][col+1].getColor() == color && cells[row][col+2].getColor() == color){
                JOptionPane.showMessageDialog(null, "movimento invalido\n");
                return false;
            }
        }

        return true;

    }


    

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                sb.append( cells[i][j].toString() );
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    Color getColor(int i , int j){
        return cells[i][j].getColor();
    }


    public int getRows() {
        return rows;
    }




    public int getCols() {
        return cols;
    }

}
