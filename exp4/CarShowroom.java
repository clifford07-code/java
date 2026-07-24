package exp4;
import java.util.*;

class Car {
    private String model;
    private double price;
    private double mileage;

    public Car() {
        model = "";
        price = 0;
        mileage = 0;
    }

    public Car(String model, double price, double mileage) {
        this.model = model;
        this.price = price;
        this.mileage = mileage;
    }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public double getMileage() { return mileage; }
    public void setMileage(double mileage) { this.mileage = mileage; }

    public String toString() {
        return "Model: " + model + "\nPrice: " + price + "\nMileage: " + mileage;
    }
}

public class CarShowroom {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of cars: ");
        int n = sc.nextInt();
        sc.nextLine();

        Car[] cars = new Car[n];
        double max = 0;
        int index = 0;

        for(int i=0;i<n;i++) {
            System.out.println("\nEnter car details:");
            System.out.print("Model: ");
            String model = sc.nextLine();
            System.out.print("Price: ");
            double price = sc.nextDouble();
            System.out.print("Mileage: ");
            double mileage = sc.nextDouble();
            sc.nextLine();

            cars[i] = new Car(model, price, mileage);

            if(price > max) {
                max = price;
                index = i;
            }
        }

        System.out.println("\nMost Expensive Car:");
        System.out.println(cars[index]);
    }
}