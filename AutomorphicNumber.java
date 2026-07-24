import java.util.*;

public class AutomorphicNumber{
	public static void main(String args[]){
		System.out.println("enter a number");
		Scanner sc= new Scanner(System.in);
		int n=sc.nextInt();
		
		int s= n*n;
		int temp=n;
		if(temp%10==s%10){
			System.out.println("it is a Automorphic Number");
		}
		else{
			System.out.println("it is not Automorphic Number");
		}
		
	}
}