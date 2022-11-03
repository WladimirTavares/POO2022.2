// Classe Car serializável para armazenar carros como objetos
import java.io.Serializable;

public class Car implements Serializable {
    private String registration; 
    private transient String make; // marcado como "transient"
    private double price;

    public Car(String registration, String make, double price) {
        this.registration = registration;
        this.make = make;
        this.price = price;
    }

    public String getRegistration() {
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