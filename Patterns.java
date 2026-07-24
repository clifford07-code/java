import java.util.*;

public class Patterns{
	public static void main(String args[]){
		System.out.println("Enter the value rows");
		Scanner sc= new Scanner(System.in);
		int n=sc.nextInt();
		int i,j;
		for(i=n;i>=0;i--){
			for(j=1;j<=i;j++){
				System.out.print("*");
			}
			System.out.println(" ");
		}
	}
}