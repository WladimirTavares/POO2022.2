import java.util.Scanner;

public class DemoData {
    public static void main(String[] args) throws Exception {
        Data descobrimentoDoBrasil = new Data( (byte)22, (byte)4, (short)1500 );
        System.out.print("Dia do descobrimento do Brasil: ");
        descobrimentoDoBrasil.mostraData();

        Data data = new Data( (byte)8, (byte)2, (short)1994 );
        data.setDia((byte) 0);
        data.setMes((byte) 13);
        data.setAno((short)2025);

        Data data2 = new Data(data);

        data.mostraData();
    }
}
