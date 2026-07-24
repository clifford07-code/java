package exp7;

import java.util.*;

class Bank {
    String name;

    Bank(String name) {
        this.name = name;
    }

    double getInterestRate() {
        return 0;
    }

    public String toString() {
        return "Bank: " + name;
    }
}

class SBI extends Bank {
    SBI() {
        super("SBI");  
    }

    double getInterestRate() {
        return 6.5;
    }
}

class HDFC extends Bank {
    HDFC() {
        super("HDFC");  
    }

    double getInterestRate() {
        return 7.0;
    }
}

class ICICI extends Bank {
    ICICI() {
        super("ICICI");   
    }

    double getInterestRate() {
        return 6.8;
    }
}

public class BankInterest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Choose Bank: 1.SBI 2.HDFC 3.ICICI");
        int choice = sc.nextInt();

        Bank b;

        if (choice == 1) b = new SBI();
        else if (choice == 2) b = new HDFC();
        else b = new ICICI();

        System.out.println(b); 
        System.out.println("Interest Rate: " + b.getInterestRate() + "%");
    }
}