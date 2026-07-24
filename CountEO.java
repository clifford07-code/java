import java.util.*;

public class CountEO{
	public static void main(String args[]){
		System.out.println("enter the number");
		Scanner sc=new Scanner(System.in);
		int n = sc.nextInt();
		int countE=0;
		int countO=0;
		
		while(n>0){
			int digit=n%10;
			if(digit%2==0){
				countE++;
			}
			else{
				countO++;
			}
			n=n/10;
		}
		
		System.out.println("even digit:"+countE);
		System.out.println("odd digit:"+countO);
	}
}