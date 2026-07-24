package exp3;

import java.util.*;

public class OnlyDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        boolean flag = true;

        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                flag = false;
                break;
            }
        }

        if (flag)
            System.out.println("String contains only digits");
        else
            System.out.println("String does NOT contain only digits");
    }
}
