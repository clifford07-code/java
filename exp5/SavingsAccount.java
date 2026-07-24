package exp5;

class SavingsAccount {

    double balance;
    static double interestRate = 5;

    SavingsAccount(double balance) {
        this.balance = balance;
    }

    double calculateInterest() {
        return (balance * interestRate) / 100;
    }

    static void updateInterestRate(double newRate) {
        interestRate = newRate;
    }
}
