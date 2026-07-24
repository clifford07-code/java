package exp6;

import java.util.Scanner;

abstract class BankAccount {
    private int accountNumber;
    private double balance;

    BankAccount(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Getters & Setters
    public int getAccountNumber() { return accountNumber; }
    public void setAccountNumber(int accountNumber) { this.accountNumber = accountNumber; }

    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }

    abstract double computeInterest();

    public void displayAccountDetails() {
        System.out.println("Account No: " + accountNumber);
        System.out.println("Balance: " + balance);
    }
}

class SavingsAccount extends BankAccount {
    SavingsAccount(int acc, double bal) {
        super(acc, bal);
    }

    double computeInterest() {
        return getBalance() * 0.04;
    }
}

class FixedDepositAccount extends BankAccount {
    FixedDepositAccount(int acc, double bal) {
        super(acc, bal);
    }

    double computeInterest() {
        return getBalance() * 0.07;
    }
}

public class BankDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of accounts: ");
        int n = sc.nextInt();

        BankAccount[] acc = new BankAccount[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\n1.Savings 2.Fixed Deposit");
            int ch = sc.nextInt();

            System.out.print("Enter Account No: ");
            int no = sc.nextInt();

            System.out.print("Enter Balance: ");
            double bal = sc.nextDouble();

            if (ch == 1)
                acc[i] = new SavingsAccount(no, bal);
            else
                acc[i] = new FixedDepositAccount(no, bal);
        }

        System.out.println("\nAccount Details\n");
        for (BankAccount a : acc) {
            a.displayAccountDetails();
            System.out.println("Interest: " + a.computeInterest());
            System.out.println();
        }
    }
}