package exp7;

import java.util.*;

class PaymentProcessor {
    int amount;
    String type;

    PaymentProcessor() {
        amount = 0;
        type = "None";
    }

    PaymentProcessor(int amount, String type) {
        this.amount = amount;
        this.type = type;
    }

    public int getAmount() { return amount; }
    public void setAmount(int amount) { this.amount = amount; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    void pay(int amount) {
        this.amount = amount;
        this.type = "Cash";
        System.out.println("Paid Rs." + amount + " using Cash");
    }

    void pay(int amount, String cardType) {
        this.amount = amount;
        this.type = cardType + " Card";
        System.out.println("Paid Rs." + amount + " using " + cardType + " card");
    }

    void pay(double amount, String wallet) {
        this.amount = (int) amount;
        this.type = wallet + " Wallet";
        System.out.println("Paid Rs." + amount + " using " + wallet + " wallet");
    }

    public String toString() {
        return "Amount: Rs." + amount + ", Payment Type: " + type;
    }
}

public class PaymentSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        PaymentProcessor p = new PaymentProcessor();

        System.out.print("Enter amount: ");
        int amt = sc.nextInt();

        System.out.print("Enter card type: ");
        String card = sc.next();

        System.out.print("Enter wallet name: ");
        String wallet = sc.next();

   
        p.pay(amt);
        p.pay(amt, card);
        p.pay((double) amt, wallet);

        System.out.println("\nFinal Payment Details:");
        System.out.println(p);
    }
}