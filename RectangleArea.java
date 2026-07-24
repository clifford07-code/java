import java.util.Scanner;

class Rectangle {
   private double l;
   private double b;
   
   Rectangle(){
       l=0.0;
       b=0.0;
   }
   Rectangle(double l,double b){
       this.l=l;
       this.b=b;
   }
   
 public  void setl(double l){
       this.l=l;
   }
   
   public double getl(){
       return l;
   }

    public double getb(){
        return b;
    }
   
   public  void setb(double b){
       this.b=b;
   }
   
   public String toString(){
       return "length"+l+",breath"+b;
   }
   
   public double area(){
       return l*b;
   }
}

public class RectangleArea {
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("enter the number of Rectangle");
    int n = sc.nextInt();
    
    Rectangle Rectangles[]=new Rectangle[n];
    
    for(int i=0;i<n;i++){
        Rectangles[i]=new Rectangle();
         System.out.println("enter the l");
         Rectangles[i].setl(sc.nextDouble());
          System.out.println("enter the b");
           Rectangles[i].setb(sc.nextDouble());
    }
    for(int i=0;i<n;i++){
         System.out.println(Rectangles[i]+"="+Rectangles[i].area());
    }
    
}
    
}
