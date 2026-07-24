import java.util.*;

public class SelectionSort{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		System.out.println("enter how many element");
		int n = sc.nextInt();
		System.out.println("enter the element");
		int arr[]=new int[n];
		for(int i=0; i<n; i++){
			arr[i]= sc.nextInt();
		}
		
		for(int i=0; i<n-1;i++){
			int min=i;
			for(int j=i+1; j<n;j++){
				if(arr[j]<arr[min]){
					min=j;
				}
			}
			int temp=arr[i];
			arr[i]=arr[min];
			arr[min]=temp;
		}
		
		System.out.println("soprted array");
		for(int i=0; i<n; i++){
			System.out.print(arr[i]+" ");
		}
	}
}