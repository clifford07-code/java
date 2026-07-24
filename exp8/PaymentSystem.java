package exp8;

import java.util.Scanner;

abstract class Payment {

    abstract void processPayment();

    final void generateReceipt() {
        System.out.println("Receipt Generated Successfully");
    }
}

class CreditCardPayment extends Payment {
    void processPayment() {
        System.out.println("Credit Card Payment Done");
    }
}

class UPIPayment extends Payment {
    void processPayment() {
        System.out.println("UPI Payment Done");
    }
}

public class PaymentSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("1. Credit Card\n2. UPI");
        int choice = sc.nextInt();

        Payment p;

        if (choice == 1)
            p = new CreditCardPayment();
        else
            p = new UPIPayment();

        p.processPayment();
        p.generateReceipt();
    }
}