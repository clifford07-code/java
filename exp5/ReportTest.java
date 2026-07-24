package exp5;

import java.util.Scanner;

public class ReportTest {
    public static void main(String[] args) {

      Scanner sc = new Scanner(System.in);

System.out.print("Enter number of students: ");
int n = sc.nextInt();

System.out.print("Enter number of subjects: ");
int sub = sc.nextInt();   

ReportCard students[] = new ReportCard[n];

for(int i = 0; i < n; i++) {

    students[i] = new ReportCard();

    int marks[] = new int[sub];

    System.out.println("Enter marks for student " + (i+1));

    for(int j = 0; j < sub; j++) {
        System.out.print("Enter mark " + (j+1) + ": ");
        marks[j] = sc.nextInt();
    }

    students[i].inputMarks(marks);
}

ReportCard.generateClassReport(students);
    }
}