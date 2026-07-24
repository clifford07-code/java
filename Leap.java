/**
 * Leap
 */
class Mye extends Exception {
	Mye(String mag){
		super(mag);
	}
	
}

public class Leap{
	public static void main(String[] args) {
		try{
			int age =15;
			if(18>age){
				throw new Mye("need to be 18");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}