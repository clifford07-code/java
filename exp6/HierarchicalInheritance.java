package exp6;

import java.util.Scanner;

class Employee {
    private String name;
    private double basicSalary;

    // Constructor
    Employee(String name, double basicSalary) {
        this.name = name;
        this.basicSalary = basicSalary;
    }

    // Getters & Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getBasicSalary() { return basicSalary; }
    public void setBasicSalary(double basicSalary) { this.basicSalary = basicSalary; }

    public double calculateSalary() {
        return basicSalary;
    }

    public String toString() {
        return "Name: " + name + "\nSalary: " + calculateSalary();
    }
}

class Developer extends Employee {
    Developer(String name, double basicSalary) {
        super(name, basicSalary);
    }

    public double calculateSalary() {
        return getBasicSalary() + 5000; // bonus
    }
}

class Manager extends Employee {
    Manager(String name, double basicSalary) {
        super(name, basicSalary);
    }

    public double calculateSalary() {
        return getBasicSalary() + 10000; // higher bonus
    }
}

class Intern extends Employee {
    Intern(String name, double basicSalary) {
        super(name, basicSalary);
    }

    public double calculateSalary() {
        return getBasicSalary() + 1000; // small allowance
    }
}

public class PayrollSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();
        sc.nextLine();

        Employee[] emp = new Employee[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\n1.Developer 2.Manager 3.Intern");
            int ch = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Basic Salary: ");
            double sal = sc.nextDouble();

            switch (ch) {
                case 1: emp[i] = new Developer(name, sal); break;
                case 2: emp[i] = new Manager(name, sal); break;
                case 3: emp[i] = new Intern(name, sal); break;
            }
        }

        System.out.println("\nEmployee Details\n");
        for (Employee e : emp) {
            System.out.println(e);
            System.out.println();
        }
    }
}