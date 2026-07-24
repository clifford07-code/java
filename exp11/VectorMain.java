package exp11;

import java.util.Scanner;
import java.util.Vector;
class Student {
    String name;
    char grade;
    Student() {
        name = "";
        grade = 'F';
    }
    Student(String name, char grade) {
        this.name = name;
        this.grade = grade;
    }
    public String toString() {
        return "Student Name: " + name +
                "\nGrade: " + grade + "\n";
    }
}
public class VectorMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Vector<Student> students = new Vector<>();
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details of Student " + (i + 1));
            System.out.print("Enter student name: ");
            String name = sc.nextLine();
            System.out.print("Enter grade (A-F): ");
            char grade = sc.next().charAt(0);
            sc.nextLine();
            students.add(new Student(name, grade));
        }
        System.out.println("\nStudent Details:");
        for (Student s : students) {
            System.out.println(s);
        }
        int a = 0, b = 0, c = 0, d = 0, e = 0, f = 0;
        for (Student s : students) {
            switch (s.grade) {
                case 'A':
                    a++;
                    break;
                case 'B':
                    b++;
                    break;
                case 'C':
                    c++;
                    break;
                case 'D':
                    d++;
                    break;
                case 'E':
                    e++;
                    break;
                case 'F':
                    f++;
                    break;
            }
        }
        System.out.println("Grade Frequency Table");
        System.out.println("A = " + a);
        System.out.println("B = " + b);
        System.out.println("C = " + c);
        System.out.println("D = " + d);
        System.out.println("E = " + e);
        System.out.println("F = " + f);
    }
}