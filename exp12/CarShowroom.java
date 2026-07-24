package exp12;

import java.io.*;
import java.util.*;
class Car {
    private String model;
    private double price;
    private double mileage;
    Car() {
        model = "";
        price = 0;
        mileage = 0;
    }
    Car(String model, double price, double mileage) {
        this.model = model;
        this.price = price;
        this.mileage = mileage;
    }
    public double getPrice() {
        return price;
    }
    public String toString() {
        return "Model: " + model +
                "\nPrice: " + price +
                "\nMileage: " + mileage;
    }
}
public class CarShowroom {
    public static void main(String[] args) throws Exception {
        Scanner file = new Scanner(new File("exp12/car.txt"));
        int n = Integer.parseInt(file.nextLine());
        Car[] cars = new Car[n];
        double max = 0;
        int index = 0;
        for (int i = 0; i < n; i++) {
            String model = file.nextLine();
            double price = Double.parseDouble(file.nextLine());
            double mileage = Double.parseDouble(file.nextLine());
            cars[i] = new Car(model, price, mileage);
            if (price > max) {
                max = price;
                index = i;
            }
        }
        PrintWriter out = new PrintWriter("exp12/car_output.txt");
        out.println("Most Expensive Car");
        out.println(cars[index]);
        out.close();
        file.close();
        System.out.println("Data written to car_output.txt");
    }
}