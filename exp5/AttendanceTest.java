package exp5;

import java.util.Scanner;

public class AttendanceTest {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        StudentAttendance students[] = new StudentAttendance[n];

        for(int i=0;i<n;i++){
            students[i] = new StudentAttendance();

            System.out.print("Enter number of classes for student " + (i+1) + ": ");
            int classes = sc.nextInt();

            for(int j=0;j<classes;j++){
                System.out.print("Present? (true/false): ");
                boolean present = sc.nextBoolean();
                students[i].markAttendance(present);
            }
        }

        System.out.println("Average Class Attendance: " +
                StudentAttendance.calculateClassAttendance(students));
    }
}