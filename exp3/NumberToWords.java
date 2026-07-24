package exp3;

import java.util.*;

public class NumberToWords {

    static String[] units = {"", "One", "Two", "Three", "Four", "Five",
            "Six", "Seven", "Eight", "Nine", "Ten", "Eleven",
            "Twelve", "Thirteen", "Fourteen", "Fifteen",
            "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

    static String[] tens = {"", "", "Twenty", "Thirty", "Forty",
            "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number (0-999): ");
        int num = sc.nextInt();

        System.out.println("In words: " + convert(num));
    }

    static String convert(int num) {
        if (num == 0)
            return "Zero";
        else if (num < 20)
            return units[num];
        else if (num < 100)
            return tens[num / 10] + " " + units[num % 10];
        else if (num < 1000)
            return units[num / 100] + " Hundred " + convert(num % 100);
        else
            return "Number too large";
    }
}
