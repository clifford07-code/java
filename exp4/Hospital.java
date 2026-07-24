package exp4;
import java.util.*;

class Patient {
    private int patientId;
    private String name;
    private double billAmount;

    // Default Constructor
    public Patient() {
        patientId = 0;
        name = "";
        billAmount = 0;
    }

    public Patient(int patientId, String name, double billAmount) {
        this.patientId = patientId;
        this.name = name;
        this.billAmount = billAmount;
    }

    public int getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public double getBillAmount() {
        return billAmount;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBillAmount(double billAmount) {
        this.billAmount = billAmount;
    }

    public String toString() {
        return "Patient ID: " + patientId +
               "\nName: " + name +
               "\nBill Amount: " + billAmount;
    }
}

public class Hospital {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of patients: ");
        int n = sc.nextInt();

        Patient[] patients = new Patient[n];
        double total = 0;

        for(int i = 0; i < n; i++) {

            patients[i] = new Patient();

            System.out.println("\nEnter Patient Details");

            System.out.print("ID: ");
            patients[i].setPatientId(sc.nextInt());

            sc.nextLine();

            System.out.print("Name: ");
            patients[i].setName(sc.nextLine());

            System.out.print("Bill Amount: ");
            patients[i].setBillAmount(sc.nextDouble());

            total += patients[i].getBillAmount();
        }

        System.out.println("\nPatient Details:");
        for(int i = 0; i < n; i++) {
            System.out.println(patients[i]);
            System.out.println();
        }

        System.out.println("Total Bill Collected: " + total);
    }
}