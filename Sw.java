import java.util.*;
import java.io.*;

interface Printable {
    void display();
}

class InvalidMarksException extends Exception {
    InvalidMarksException(String msg) {
        super(msg);
    }
}

class Student implements Printable {
    String name;
    int marks;

    Student(String name, int marks) throws InvalidMarksException {
        if (marks < 0 || marks > 100) {
            throw new InvalidMarksException("Marks must be between 0 and 100");
        }

        this.name = name;
        this.marks = marks;
    }

    public void display() {
        System.out.println("Name: " + name + ", Marks: " + marks);
    }
}

public class Sw {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            try {
                System.out.print("\nEnter name: ");
                String name = sc.nextLine();

                System.out.print("Enter marks: ");
                int marks = sc.nextInt();
                sc.nextLine();

                Student s = new Student(name, marks);
                students.add(s);

            } catch (InvalidMarksException e) {
                System.out.println("Error: " + e.getMessage());
                i--; // re-enter this student
            }
        }

        System.out.println("\nStudent Details:");
        for (Student s : students) {
            s.display();
        }

        try {
            FileWriter fw = new FileWriter("students.txt");

            for (Student s : students) {
                fw.write("Name: " + s.name +
                         ", Marks: " + s.marks + "\n");
            }

            fw.close();
            System.out.println("\nData written to students.txt");

        } catch (IOException e) {
            System.out.println("File Error: " + e.getMessage());
        }

        sc.close();
    }
}