package exp5;

import java.util.Scanner;

public class AccountTest {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter balance: ");
        double balance = sc.nextDouble();

        SavingsAccount acc1 = new SavingsAccount(balance);

        System.out.print("Enter new interest rate: ");
        double rate = sc.nextDouble();

        SavingsAccount.updateInterestRate(rate);

        System.out.println("Interest: " + acc1.calculateInterest());
    }
}
