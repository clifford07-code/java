import java.util.Scanner;

interface EquityAnalyzer {

    default double sharpeRatio(double returnRate, double riskFreeRate, double stdDev) {
        return (returnRate - riskFreeRate) / stdDev;
    }
}

interface DebtAnalyzer {

    default double yieldToMaturity(double faceValue, double couponRate, double price, int years) {

        double annualCoupon = faceValue * (couponRate / 100);

        return ((annualCoupon + ((faceValue - price) / years)) / ((faceValue + price) / 2)) * 100;
    }
}

class MixedPortfolio implements EquityAnalyzer, DebtAnalyzer {

    private double equityInvestment;
    private double debtInvestment;
    private double equityReturn;
    private double debtReturn;
    private double targetEquityAllocation;
    private double targetDebtAllocation;

    MixedPortfolio() {
        equityInvestment = 0;
        debtInvestment = 0;
        equityReturn = 0;
        debtReturn = 0;
        targetEquityAllocation = 50;
        targetDebtAllocation = 50;
    }

    MixedPortfolio(double equityInvestment, double debtInvestment,
                   double equityReturn, double debtReturn,
                   double targetEquityAllocation, double targetDebtAllocation) {

        this.equityInvestment = equityInvestment;
        this.debtInvestment = debtInvestment;
        this.equityReturn = equityReturn;
        this.debtReturn = debtReturn;
        this.targetEquityAllocation = targetEquityAllocation;
        this.targetDebtAllocation = targetDebtAllocation;
    }

    public double calculatePortfolioReturn() {

        double totalInvestment = equityInvestment + debtInvestment;

        return ((equityInvestment * equityReturn) +
                (debtInvestment * debtReturn)) / totalInvestment;
    }

    public void rebalanceRecommendation() {

        double totalInvestment = equityInvestment + debtInvestment;

        double currentEquityPercent = (equityInvestment / totalInvestment) * 100;
        double currentDebtPercent = (debtInvestment / totalInvestment) * 100;

        System.out.println("\nCurrent Equity Allocation: " + currentEquityPercent + "%");
        System.out.println("Current Debt Allocation: " + currentDebtPercent + "%");

        if (Math.abs(currentEquityPercent - targetEquityAllocation) > 5 ||
                Math.abs(currentDebtPercent - targetDebtAllocation) > 5) {

            System.out.println("Recommendation: Portfolio Rebalancing Required.");
        } else {
            System.out.println("Portfolio Allocation is Balanced.");
        }
    }

    public String toString() {

        return "\n----- Portfolio Details -----" +
                "\nEquity Investment: ₹" + equityInvestment +
                "\nDebt Investment: ₹" + debtInvestment +
                "\nEquity Return: " + equityReturn + "%" +
                "\nDebt Return: " + debtReturn + "%" +
                "\nTarget Equity Allocation: " + targetEquityAllocation + "%" +
                "\nTarget Debt Allocation: " + targetDebtAllocation + "%";
    }
}

public class PortfolioRiskAnalyzer {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Equity Investment: ");
        double equityInvestment = sc.nextDouble();

        System.out.print("Enter Debt Investment: ");
        double debtInvestment = sc.nextDouble();

        System.out.print("Enter Equity Return (%): ");
        double equityReturn = sc.nextDouble();

        System.out.print("Enter Debt Return (%): ");
        double debtReturn = sc.nextDouble();

        System.out.print("Enter Target Equity Allocation (%): ");
        double targetEquity = sc.nextDouble();

        System.out.print("Enter Target Debt Allocation (%): ");
        double targetDebt = sc.nextDouble();

        MixedPortfolio mp = new MixedPortfolio(
                equityInvestment,
                debtInvestment,
                equityReturn,
                debtReturn,
                targetEquity,
                targetDebt
        );

        System.out.println(mp);

        double portfolioReturn = mp.calculatePortfolioReturn();

        System.out.println("\nWeighted Portfolio Return: " + portfolioReturn + "%");

        System.out.print("\nEnter Risk Free Rate (%): ");
        double riskFreeRate = sc.nextDouble();

        System.out.print("Enter Standard Deviation: ");
        double stdDev = sc.nextDouble();

        double sharpe = mp.sharpeRatio(portfolioReturn, riskFreeRate, stdDev);

        System.out.println("Overall Sharpe Ratio: " + sharpe);

        // YTM
        System.out.print("\nEnter Bond Face Value: ");
        double faceValue = sc.nextDouble();

        System.out.print("Enter Coupon Rate (%): ");
        double couponRate = sc.nextDouble();

        System.out.print("Enter Bond Price: ");
        double price = sc.nextDouble();

        System.out.print("Enter Years to Maturity: ");
        int years = sc.nextInt();

        double ytm = mp.yieldToMaturity(faceValue, couponRate, price, years);

        System.out.println("Yield To Maturity (YTM): " + ytm + "%");

        mp.rebalanceRecommendation();

        sc.close();
    }
}