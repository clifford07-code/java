import java.util.*;

public class KthElement{
	public static void main(String args[]){
		
		Scanner sc=new Scanner(System.in);
		System.out.println("enter how many element");
		int n = sc.nextInt();
		System.out.println("enter the element");
		int arr[]=new int[n];
		for(int i=0; i<n; i++){
			arr[i]= sc.nextInt();
		}
		
		System.out.println("enter K value");
		int k = sc.nextInt();
		
		Arrays.sort(arr);
		System.out.println("enter how many element"+arr[n-k]);
		

		
		
	}
}