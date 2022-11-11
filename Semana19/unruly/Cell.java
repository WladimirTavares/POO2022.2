import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Cell {
    int row;
    int col;
    Color color;
    String rep;
    boolean fixed;

    public Cell(int row, int col, Color color) {
        this.row = row;
        this.col = col;
        this.color = color;
        if (color == Color.GRAY) {
            rep = "G";
            fixed = false;
        } else if (color == Color.BLACK) {
            rep = "B";
            fixed = true;
        } else {
            rep = "W";
            fixed = true;
        }

    }

    public int getRow() {
        return row;
    }

    public Color getColor() {
        return color;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    @Override
    public String toString() {
        return rep;
    }

    public boolean isFixed() {
        return fixed;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getRep() {
        return rep;
    }

}
