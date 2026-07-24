package exp8;

import java.util.Scanner;

abstract class Employee {
    private String name;
    private int id;

    Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    abstract double calculateSalary();

    void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
    }
}

class Manager extends Employee {
    private double bonus;

    Manager(String name, int id, double bonus) {
        super(name, id);
        this.bonus = bonus;
    }

    public double getBonus() { return bonus; }
    public void setBonus(double bonus) { this.bonus = bonus; }

    double calculateSalary() {
        return 50000 + bonus;
    }
}

class Developer extends Employee {
    private int hours;
    private double rate;

    Developer(String name, int id, int hours, double rate) {
        super(name, id);
        this.hours = hours;
        this.rate = rate;
    }

    public int getHours() { return hours; }
    public void setHours(int hours) { this.hours = hours; }

    public double getRate() { return rate; }
    public void setRate(double rate) { this.rate = rate; }

    double calculateSalary() {
        return hours * rate;
    }
}

public class EmployeeSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Manager Name: ");
        String name = sc.nextLine();
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        System.out.print("Enter Bonus: ");
        double bonus = sc.nextDouble();

        Employee e1 = new Manager(name, id, bonus);

        e1.displayDetails();
        System.out.println("Salary: " + e1.calculateSalary());
    }
}