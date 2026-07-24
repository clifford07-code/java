import java.util.Scanner;

class Itpra {
    private String name ;
    private int num;
    private double unit;

    Itpra(){
        name="";
        num=0;
        unit=0.0;
    }

    
    Itpra(String name,int num,double unit){
        this.name=name;
        this.num=num;
        this.unit=unit;
    }

    public void setname(String name){
        this.name=name;
    }

    public void setnum(int num){
        this.num=num;
    }

    public void setunit(double unit){
        this.unit=unit;
    }

    public String getname(){
        return name;
    }
      public int getnum(){
        return num;
    }

      public double getunit(){
        return unit;
    }

    public String toString(){
            return "name"+name+"num"+num+"unit"+unit;
    }
}

public class InnerItpra {
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("enter the number of customer");
    int n = sc.nextInt();
    Itpra Itpras[]=new Itpra[n];
    for(int i=0;i<n;i++){
         sc.nextLine();
        System.out.println("enter the name of customer");
        String name=sc.nextLine();
         System.out.println("enter the number of customer");
        int num=sc.nextInt();
          System.out.println("enter the unit  of customer"); 
          double unit=sc.nextDouble();
        Itpras[i]=new Itpra(name,num,unit);
    }

    for(int i=0;i<n;i++){
        double u=Itpras[i].getunit();
        double bill = u *5.0;
        System.out.println(Itpras[i].getname()+"="+bill);
    }
}
    
}
