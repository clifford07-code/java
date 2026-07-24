import java.util.*;

public class DecimalBinary{
	public static void main(String args[]){
		System.out.println("enter the decimal number");
		Scanner sc=new Scanner(System.in);
		int n = sc.nextInt();
		String bin="";
		while(n>0){
			int rem=n%2;
			bin=rem+bin;
			 n=n/2;
		}
		System.out.println(bin);
	}
}