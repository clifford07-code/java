package exp7;

import java.util.*;

class Product {
    String name;
    double price;

    Product() {
        name = "Unknown";
        price = 0;
    }

    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    double getDiscount() {
        return 0;
    }

    public String toString() {
        return "Product: " + name + ", Price: Rs." + String.format("%.2f", price);
    }
}

class Electronics extends Product {
    Electronics(String name, double price) {
        super(name, price);
    }

        double getDiscount() {
            return price * 0.10;   
        }
    }

    class Clothing extends Product {
        Clothing(String name, double price) {
        super(name, price);
    }

    double getDiscount() {
        return price * 0.20;   
    }
}

public class OnlineShopping {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Choose Product: 1.Electronics 2.Clothing");
        int choice = sc.nextInt();

        sc.nextLine();

        System.out.print("Enter product name: ");
        String name = sc.nextLine();

        System.out.print("Enter price: ");
        double price = sc.nextDouble();

        Product p;

        if (choice == 1)
            p = new Electronics(name, price);
        else
            p = new Clothing(name, price);

        System.out.println(p);
        System.out.println("Discount: Rs." + String.format("%.2f", p.getDiscount()));
    }
}