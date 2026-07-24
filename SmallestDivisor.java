import java.util.*;

public class SmallestDivisor{
	public static void main(String args[]){
		System.out.println("enter a number");
		Scanner sc=new Scanner(System.in);
		int n = sc.nextInt();
		
		if(n<=2){
			System.out.println("no divisor other then 1");
			return;
		}
		
		for(int i=2;i<=n;i++){
			if(n%i==0){
				System.out.println("smallest divisor other than i is:"+i);
				break;
			}
		}
		
		
	}
}