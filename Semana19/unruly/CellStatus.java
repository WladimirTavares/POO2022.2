import java.awt.Color;

public enum CellStatus {
    BRANCO("W", Color.WHITE), PRETO("B", Color.BLACK), CINZA("G", Color.GRAY);

    String rep;
    Color color;

    private CellStatus(String rep, Color color) {
        this.rep = rep;
        this.color = color;
    }

    public String getRep() {
        return rep;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public String toString() {
        return rep;
    }

}
