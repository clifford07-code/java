import java.util.Scanner;

interface Transactable {
    void deposit(double amt);
    void withdraw(double amt);

    default double transactionFee(double amt) {
        return amt * 0.002;
    }
}

interface Investable extends Transactable {

    void allocateFunds(double amt, String asset);

    default double expectedReturn(double p, double r, int y) {
        return p * Math.pow((1 + (r / (100 * 4))), 4 * y);
    }
}

interface RetirementInvestable extends Investable {

    double calculateMaturityValue(int years);

    default double inflationAdjustedValue(double fv, double inf, int y) {
        return fv / Math.pow((1 + inf / 100), y);
    }
}

interface Auditable {

    default double generateRiskScore(double v, int missed) {
        return Math.min((v * 40) + (missed * 15), 100);
    }
}

interface RegulatoryCompliant extends Auditable {

    void submitComplianceReport();

    default double penaltyForNonCompliance(double value) {
        return value * 0.035;
    }
}

class Account {

    protected String accNo, name;
    protected double balance;

    Account() {
        accNo = "";
        name = "";
        balance = 0;
    }

    Account(String accNo, String name, double balance) {
        this.accNo = accNo;
        this.name = name;
        this.balance = balance;
    }

    double getBalance() {
        return balance;
    }

    void printStatement() {
        System.out.println("\nAccount: " + accNo);
        System.out.println("Name: " + name);
        System.out.println("Balance: ₹" + balance);
    }

    public String toString() {
        return "\nAcc No: " + accNo +
                "\nName: " + name +
                "\nBalance: ₹" + balance;
    }
}

class InvestmentAccount extends Account {

    protected double portfolio;
    protected String risk;

    InvestmentAccount() {
        super();
        portfolio = 0;
        risk = "";
    }

    InvestmentAccount(String accNo, String name, double balance,
                      double portfolio, String risk) {

        super(accNo, name, balance);
        this.portfolio = portfolio;
        this.risk = risk;
    }

    public String toString() {
        return super.toString() +
                "\nPortfolio: ₹" + portfolio +
                "\nRisk Appetite: " + risk;
    }
}

class PensionFundAccount extends InvestmentAccount
        implements RetirementInvestable, RegulatoryCompliant {

    double monthly, annualReturn, inflation, volatility;
    int missedPayments;

    PensionFundAccount() {
        super();
    }

    PensionFundAccount(String accNo, String name, double balance,
                       double portfolio, String risk,
                       double monthly, double annualReturn,
                       double inflation, double volatility,
                       int missedPayments) {

        super(accNo, name, balance, portfolio, risk);

        this.monthly = monthly;
        this.annualReturn = annualReturn;
        this.inflation = inflation;
        this.volatility = volatility;
        this.missedPayments = missedPayments;
    }

    public void deposit(double amt) {
        balance += amt;
        System.out.println("Deposited: ₹" + amt);
    }

    public void withdraw(double amt) {

        if (amt <= balance) {
            balance -= amt;
            System.out.println("Withdrawn: ₹" + amt);
        } else {
            System.out.println("Insufficient Balance");
        }
    }

    public void allocateFunds(double amt, String asset) {
        System.out.println("₹" + amt + " invested in " + asset);
    }

    // Diamond Problem Resolved
    public double transactionFee(double amt) {
        return amt * 0.0005;
    }

    public double calculateMaturityValue(int years) {

        double total = 0;
        double contribution = monthly;

        for (int i = 1; i <= years; i++) {

            total = (total + contribution * 12)
                    * (1 + annualReturn / 100);

            contribution *= 1.05;
        }

        return total;
    }

    public void submitComplianceReport() {

        double riskScore =
                generateRiskScore(volatility, missedPayments);

        double maturity =
                calculateMaturityValue(30);

        double adjusted =
                inflationAdjustedValue(maturity, inflation, 30);

        double taxExempt =
                Math.min(monthly * 12, 150000);

        double taxable = maturity - taxExempt;

        double penalty = 0;

        if (riskScore > 70)
            penalty = penaltyForNonCompliance(maturity);

        System.out.println("\n--- Compliance Report ---");
        System.out.println("Risk Score: " + riskScore);
        System.out.println("Maturity Value: ₹" + maturity);
        System.out.println("Inflation Adjusted Value: ₹" + adjusted);
        System.out.println("Tax Exempt Corpus: ₹" + taxExempt);
        System.out.println("Taxable Corpus: ₹" + taxable);
        System.out.println("Penalty: ₹" + penalty);
    }

    void growthTable(int years) {

        double total = 0;
        double contribution = monthly;

        System.out.println("\nYear\tContribution\tFund Value");

        for (int i = 1; i <= years; i++) {

            total = (total + contribution * 12)
                    * (1 + annualReturn / 100);

            System.out.println(i + "\t₹"
                    + (contribution * 12)
                    + "\t₹" + total);

            contribution *= 1.05;
        }
    }

    public String toString() {

        return super.toString() +
                "\nMonthly Contribution: ₹" + monthly +
                "\nAnnual Return: " + annualReturn + "%" +
                "\nInflation: " + inflation + "%";
    }
}

public class BankingInvestmentPlatform {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Account No: ");
        String accNo = sc.nextLine();

        System.out.print("Enter Holder Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Balance: ");
        double balance = sc.nextDouble();

        System.out.print("Enter Portfolio Value: ");
        double portfolio = sc.nextDouble();

        sc.nextLine();

        System.out.print("Enter Risk Appetite: ");
        String risk = sc.nextLine();

        System.out.print("Enter Monthly Contribution: ");
        double monthly = sc.nextDouble();

        System.out.print("Enter Annual Return Rate: ");
        double annualReturn = sc.nextDouble();

        System.out.print("Enter Inflation Rate: ");
        double inflation = sc.nextDouble();

        System.out.print("Enter Volatility: ");
        double volatility = sc.nextDouble();

        System.out.print("Enter Missed Payments: ");
        int missed = sc.nextInt();

        PensionFundAccount p =
                new PensionFundAccount(
                        accNo, name, balance,
                        portfolio, risk,
                        monthly, annualReturn,
                        inflation, volatility,
                        missed
                );

        System.out.println(p);

        System.out.print("\nEnter Deposit Amount: ");
        p.deposit(sc.nextDouble());

        System.out.print("Enter Withdraw Amount: ");
        p.withdraw(sc.nextDouble());

        sc.nextLine();

        System.out.print("Enter Asset Type: ");
        String asset = sc.nextLine();

        System.out.print("Enter Amount to Allocate: ");
        p.allocateFunds(sc.nextDouble(), asset);

        System.out.print("Enter Transaction Amount: ");
        double amt = sc.nextDouble();

        System.out.println("Transaction Fee: ₹"
                + p.transactionFee(amt));

        int years = 30;

        double maturity =
                p.calculateMaturityValue(years);

        System.out.println("\nMaturity Value: ₹" + maturity);

        System.out.println("Inflation Adjusted Value: ₹"
                + p.inflationAdjustedValue(
                maturity, inflation, years));

        p.submitComplianceReport();

        p.growthTable(years);

        p.printStatement();

        sc.close();
    }
}