package exp4;

import java.util.*;

class Mobile {
    private String brand;
    private String model;
    private double price;

    public Mobile() {
        brand = "";
        model = "";
        price = 0;
    }

    public Mobile(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getPrice() {
        return price;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String toString() {
        return "Brand: " + brand +
               "\nModel: " + model +
               "\nPrice: " + price;
    }
}

public class MobileStore {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of mobiles: ");
        int n = sc.nextInt();

        Mobile[] mobiles = new Mobile[n];

        for(int i = 0; i < n; i++) {

            mobiles[i] = new Mobile();

            sc.nextLine();

            System.out.println("\nEnter mobile details:");

            System.out.print("Brand: ");
            mobiles[i].setBrand(sc.nextLine());

            System.out.print("Model: ");
            mobiles[i].setModel(sc.nextLine());

            System.out.print("Price: ");
            mobiles[i].setPrice(sc.nextDouble());
        }

        System.out.print("\nEnter minimum price: ");
        double min = sc.nextDouble();

        System.out.print("Enter maximum price: ");
        double max = sc.nextDouble();

        System.out.println("\nMobiles within price range:");

        for(Mobile m : mobiles) {
            if(m.getPrice() >= min && m.getPrice() <= max) {
                System.out.println(m);
                System.out.println();
            }
        }
    }
}