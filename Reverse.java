public class Reverse{
		public static void main(String args[]){
			int a= 1353;
			int rev=0;
			
			while(a>0){
				int rem=a%10;
				rev=(rev*10)+rem;
				a=a/10;
			}
			System.out.print("reverse"+rev);
			
			
		}
			
}