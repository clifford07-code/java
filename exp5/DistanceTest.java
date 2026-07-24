package exp5;

import java.util.Scanner;

public class DistanceTest {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        DistanceConverter d = new DistanceConverter();

        System.out.print("Enter distance value: ");
        double value = sc.nextDouble();

        d.displayConversion(value);
    }
}