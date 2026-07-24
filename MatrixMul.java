import java.util.*;

abstract class Shape{
    String name;
    Shape(String name){
        this.name=name;
    }

    abstract double calculateArea();
    String getname(){
        return name;
    }
}

class Rectangle extends Shape{
    double len;
    double brath;
    Rectangle(String name,double len,double brath){
        super(name);
        this.len=len;
        this.brath=brath;
    }

    double calculateArea(){
        return len*brath;
    }
}

class Circle extends Shape{
    double r;
    
    Circle(String name,double r){
        super(name);
        this.r=r;
       
    }

    double calculateArea(){
        return 3.14*r*r;
    }

    double cirm(){
        return 3.14*r*r;
    }
}
public class MatrixMul {

    static void largst(Shape[] sp){
        if (sp == null || sp.length == 0) {
            System.out.println("No shapes available.");
            return;
        }
        Shape maxShape = sp[0];
        for (Shape shape : sp) {
            if (shape.calculateArea() > maxShape.calculateArea()) {
                maxShape = shape;
            }
        }
        System.out.println("Largest shape: " + maxShape.getname() + " = " + maxShape.calculateArea());
    }

    public static void main(String args[]) {
      Scanner sc =new Scanner(System.in);
      System.out.println("enter the number of shaps");
      int n= sc.nextInt();
      sc.nextLine();
        Shape sp[]=new Shape[n];
      for (int i = 0; i < n; i++) {
        System.out.println("1=reactange,2=circle");
      int c= sc.nextInt();
      sc.nextLine();
         System.out.println("enterr the name");
      String name= sc.nextLine();
      if(c==1){
        System.out.println("enter the len");
        double len=sc.nextDouble();
          System.out.println("enter the len");
        double brath=sc.nextDouble();
        sc.nextLine();
        sp[i]=new Rectangle(name, len, brath);
      }else{
         System.out.println("enter the radus");
        double r=sc.nextDouble();
        sc.nextLine();
        sp[i]=new Circle(name, r);
      }
      }

      for (Shape shape : sp) {
        if(shape.name.equalsIgnoreCase("Circle")){
            // System.out.println(shape.name+"= cirm"+shape.cirm());
        }
        System.out.println(shape.name+"="+shape.calculateArea());
      }
        largst(sp);
      
    }
    }
