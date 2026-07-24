package exp6;

import java.util.Scanner;
class Product {
    private int productId;
    private String productName;
    private double price;
    public Product() {
        productId = 0;
        productName = "";
        price = 0.0;
    }
    public Product(int productId, String productName, double price) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
    }
    public int getProductId() {
        return productId; }
    public void setProductId(int productId) {
        this.productId = productId; }
    public String getProductName() {
        return productName; }
    public void setProductName(String productName) {
        this.productName = productName; }
    public double getPrice() {
        return price; }
    public void setPrice(double price) {
        this.price = price; }
    public void displayProduct() {
        System.out.println("Product ID: " + productId);
        System.out.println("Product Name: " + productName);
        System.out.println("Price: " + price);
    }
}
class ElectronicProduct extends Product {
    private int warrantyPeriod;
    private String brand;
    public ElectronicProduct() {
        super();
        warrantyPeriod = 0;
        brand = "";
    }
    public ElectronicProduct(int productId, String productName, double price,  int warrantyPeriod, String brand) {
        super(productId, productName, price);
        this.warrantyPeriod = warrantyPeriod;
        this.brand = brand;
    }
    public int getWarrantyPeriod() {
        return warrantyPeriod; }
    public void setWarrantyPeriod(int warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod; }
    public String getBrand() {
        return brand; }
    public void setBrand(String brand) {
        this.brand = brand;}
    public void displayElectronicProduct() {
        super.displayProduct();
        System.out.println("Warranty Period: " + warrantyPeriod + " years");
        System.out.println("Brand: " + brand);
    }
}
public class ProductMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of products:");
        int n = sc.nextInt();
        sc.nextLine();
        ElectronicProduct[] products = new ElectronicProduct[n];
        for(int i = 0; i < n; i++){
            System.out.println("\nEnter the details of product " + (i+1));
            System.out.print("Enter Product ID: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter Product Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Price: ");
            double price = sc.nextDouble();
            System.out.print("Enter Warranty Period (years): ");
            int warranty = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter Brand: ");
            String brand = sc.nextLine();
            products[i] = new ElectronicProduct(id, name, price, warranty, brand);
        }
        for(int i = 0; i < n; i++){
            System.out.println("\nElectronic Product " + (i+1) + ":");
            products[i].displayElectronicProduct();
        }
    }
}