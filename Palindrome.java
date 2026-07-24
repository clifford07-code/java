import java.util.*;
import java.io.*;

interface Manageable{
	void addProduct(String pro);
	void removeProduct(String pro)throws ProductNotFoundException;
}

class ProductNotFoundException extends Exception{
	ProductNotFoundException(String msg){
		super(msg);
	}
}
class Inventory implements Manageable{
	Vector<String> product =new Vector<>();
	@Override
	public void addProduct(String pro) {
		product.add(pro);
	}

	public void removeProduct(String pro)throws ProductNotFoundException{
		if(!product.contains(pro)){
			throw new ProductNotFoundException(pro);
		}
		product.remove(pro);
	}

	void display(){
		for(String pro:product){
			System.out.println(pro);
		}
	}

	void write()throws IOException{
		FileWriter fw =new FileWriter("ooo.txt");
		for(String pro:product){
			fw.write(pro);
		}
		fw.close();
	}

}

public class Palindrome{
	public static void main(String args[]){
		Scanner sc =new Scanner(System.in);
		System.out.println("enter the number of product");
		int n=sc.nextInt();
		sc.nextLine();
		Inventory in =new Inventory();
		for (int i = 0; i < n; i++) {
			System.out.println("enter the name of product");
			String name =sc.nextLine();
			
			in.addProduct(name);
		}
		System.out.println("enter the product to be remove ");
		String name =sc.nextLine();
		try {
			in.removeProduct(name);
			
		} catch (ProductNotFoundException e) {
			System.out.println(e);
		}

		in.display();

		try {
			in.write();
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}