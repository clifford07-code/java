package exp6;

import java.util.Scanner;

class University {
    private String universityName;
    private String location;

    University() {
        universityName = "";
        location = "";
    }

    University(String universityName, String location) {
        this.universityName = universityName;
        this.location = location;
    }

 
    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String toString() {
        return "University: " + universityName + "\nLocation: " + location;
    }
}

class Department extends University {
    private String departmentName;
    private int facultyCount;

    Department() {
        super();
        departmentName = "";
        facultyCount = 0;
    }

    Department(String uName, String loc, String departmentName, int facultyCount) {
        super(uName, loc);
        this.departmentName = departmentName;
        this.facultyCount = facultyCount;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public int getFacultyCount() {
        return facultyCount;
    }

    public void setFacultyCount(int facultyCount) {
        this.facultyCount = facultyCount;
    }

    public String toString() {
        return super.toString() +
               "\nDepartment: " + departmentName +
               "\nFaculty Count: " + facultyCount;
    }
}

class Student extends Department {
    private int studentId;
    private String course;

    Student() {
        super();
        studentId = 0;
        course = "";
    }

    Student(String uName, String loc, String dept, int faculty,
            int studentId, String course) {
        super(uName, loc, dept, faculty);
        this.studentId = studentId;
        this.course = course;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String toString() {
        return super.toString() +
               "\nStudent ID: " + studentId +
               "\nCourse: " + course;
    }
}
public class MultilevelInheritence {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();

        Student[] students = new Student[n];

        for (int i = 0; i < n; i++) {

            System.out.println("\nEnter details for student " + (i + 1) + ":");

            System.out.print("Enter University Name: ");
            String u = sc.nextLine();

            System.out.print("Enter Location: ");
            String loc = sc.nextLine();

            System.out.print("Enter Department Name: ");
            String dept = sc.nextLine();

            System.out.print("Enter Faculty Count: ");
            int f = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Student ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Course: ");
            String course = sc.nextLine();

            students[i] = new Student(u, loc, dept, f, id, course);
        }

        System.out.println("\nStudent Details \n");

        for (int i = 0; i < n; i++) {
            System.out.println(students[i]);
            System.out.println();
        }
    }
}