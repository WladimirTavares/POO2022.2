
// Classe Car serializável para armazenar carros como objetos
import java.io.Serializable;

public class Car implements Serializable {
    private static int number = 1;
    private int registration;
    private String make;
    private double price;
    private ArrayList<String> acessorio;

    public Car(String make, double price) {
        this.registration = number;
        this.make = make;
        this.price = price;
        number++;
    }

    public int getRegistration() {
        return registration;
    }

    public String getMake() {
        return make;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("Registration: %s, Make: %s, Price: %.2f",
                getRegistration(), getMake(), getPrice());
    }
}