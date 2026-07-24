package exp10;

import java.util.Scanner;

class ArrayChecker {

    int marks[];

    ArrayChecker() {
        marks = new int[5];
    }

    ArrayChecker(int m[]) {
        marks = m;
    }

    int getMark(int index) {

        try {
            return marks[index];
        }

        catch (ArrayIndexOutOfBoundsException e) {

            System.out.println("Error: Index " + index +
                    " is out of bounds. Valid range is 0 to 4");

            return -1;
        }

        finally {
            System.out.println("Lookup complete");
        }
    }

    public String toString() {

        String s = "Marks: ";

        for (int i : marks) {
            s += i + " ";
        }

        return s;
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int m[] = new int[5];

        System.out.println("Enter 5 Student Marks:");

        for (int i = 0; i < 5; i++) {
            m[i] = sc.nextInt();
        }

        ArrayChecker a = new ArrayChecker(m);

        System.out.println(a);

        System.out.print("Enter Index: ");
        int index = sc.nextInt();

        int mark = a.getMark(index);

        if (mark != -1) {
            System.out.println("Mark = " + mark);
        }

        sc.close();
    }
}