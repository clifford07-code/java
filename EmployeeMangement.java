import java.util.*;

interface Taxable{
		public double calculateTax();
}

 abstract class Employee {
	private int empId;
	private String empName;
	public  double salary;
	public  double fsalary;

	Employee(int empId,String empName, double salary){
		this.empId=empId;
		this.empName=empName;
		this.salary=salary;

	}
	
	public void displayDetails(){
		System.out.println("name "+empName+"salary "+salary);
	}

	 abstract double calculateSalary();
}

 class Manager extends Employee implements Taxable {
	Manager(int empId,String empName, double salary){
		super(empId, empName, salary);
	}
	double calculateSalary(){
		return salary+5000;
	}

	public double calculateTax(){
		fsalary=salary-(salary*0.10);
		return fsalary;
	}
	
}

 class Developer extends Employee implements Taxable {
	Developer(int empId,String empName, double salary){
		super(empId, empName, salary);
	}
	double calculateSalary(){
		return salary+5000;
	}

	public double calculateTax(){
		fsalary=12*(salary-(salary*0.10));
		return fsalary;
	}
	
	
}

public class EmployeeMangement{
	public static void main(String[] args) {
		Manager M1  =new Manager(1,"clifford",5000.0);
		Developer D1  =new Developer(1,"roy",6000.0);
		D1.displayDetails();
		System.out.println(D1.calculateSalary());
		System.out.println(D1.calculateTax());

		M1.displayDetails();
		
		System.out.println(M1.calculateSalary());
		System.out.println(M1.calculateTax());


	}

	
}