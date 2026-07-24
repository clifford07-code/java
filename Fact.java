
public class Fact {

    public static void main(String[] args){
        System.out.println("entert the num");
        
        int num=5;
        int fact=1;

        for(int i = 1;i<=num;i++){
            fact=fact*i;
        }
        System.out.println("the num you entered is "+fact);
    }
}