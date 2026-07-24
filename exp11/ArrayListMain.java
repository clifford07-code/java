package exp11;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

class Product {
    String name;
    String category;
    double price;
    Product() {
        name = "";
        category = "";
        price = 0;
    }
    Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }
    public String toString() {
        return "Product Name: " + name +
                "\nCategory: " + category +
                "\nPrice: " + price + "\n";
    }
}
public class ArrayListMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Product> products = new ArrayList<>();
        System.out.print("Enter number of products: ");
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details of Product " + (i + 1));
            System.out.print("Enter product name: ");
            String name = sc.nextLine();
            System.out.print("Enter category: ");
            String category = sc.nextLine();
            System.out.print("Enter price: ");
            double price = sc.nextDouble();
            sc.nextLine();
            products.add(new Product(name, category, price));
        }
        System.out.print("\nEnter price threshold: ");
        double threshold = sc.nextDouble();
        Iterator<Product> itr = products.iterator();
        while (itr.hasNext()) {
            Product p = itr.next();
            if (p.price > threshold) {
                itr.remove();
            }
        }
        System.out.println("\nProducts below threshold:");
        for (Product p : products) {
            System.out.println(p);
        }
    }
}
