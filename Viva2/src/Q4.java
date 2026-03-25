//Triangle Calculation(non-static method)
import java.util.Scanner;
public class Q4 {
    public double getSideBySAS(double side1, double angle, double side2){
        double x =Math.cos(Math.toRadians(angle));//convert to radian first
        return Math.sqrt((side1*side1)+(side2*side2)-(2*side1*side2*x));
    }
    
    public double getAngleBySSS(double side1, double side2, double targetSide){
        double x =((side1*side1)+(side2*side2)-(targetSide*targetSide))/(2*side1*side2);
        x = Math.max(-1, Math.min(1, x));  // clamp to [-1, 1] or else NaN
        x = Math.acos(x);
        return Math.toDegrees(x);
    }
    
    public double getArea(double a, double b, double c){
        double s = (a+b+c)/2;
        double area = Math.sqrt(s*(s-a)*(s-b)*(s-c));//Heron's formula
        return area;
    }
    
    public boolean isTriangle (double a, double b, double c){
        if(a+b>c && a+c>b && b+c>a)
            return true;
        else
            return false;
    }
    
    public void displayFullOutput(double sideA,double sideB,double sideC,double angleBC,double angleAC,double angleAB, double area){
        System.out.println("Triangle Info");
        System.out.printf("Side A: %.2f\n" , sideA);
        System.out.printf("Side B: %.2f\n" , sideB);
        System.out.printf("Side C: %.2f\n" , sideC);
        System.out.printf("Angle BC: %.2f\n" , angleBC);
        System.out.printf("Angle AC: %.2f\n" , angleAC);
        System.out.printf("Angle AB: %.2f\n" , angleAB);
        System.out.printf("Area: %.2f\n" , area);
    }
    
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        Q4 q4= new Q4();
        String triangle;
        double sideA=0,sideB=0,sideC=0,angleBC=0,angleAC=0,angleAB=0,area=0;
        while(true){
            System.out.print("Choose triangle type(Enter \"(SSS)\" for side side side and \"(SAS)\" for side angle side):");
            triangle = sc.nextLine();
            if (triangle.equalsIgnoreCase("(SAS)")){
                System.out.print("Side 1: ");
                sideA = sc.nextDouble();
                System.out.print("Angle: ");
                angleAB = sc.nextDouble();
                System.out.print("Side 2: ");
                sideB = sc.nextDouble();
                sideC = q4.getSideBySAS(sideA, angleAB, sideB);
                if (!q4.isTriangle(sideA, sideB, sideC)||sideA<=0||angleAB<=0||sideB<=0){
                    System.out.println("Triangle Info");
                    System.out.printf("Side A: %.2f\n" , sideA);
                    System.out.printf("Side B: %.2f\n" , sideB);
                    System.out.printf("Side C: Invalid\n" );
                    System.out.println("Not a Valid Triangle");
                }
                else{
                    angleBC = q4.getAngleBySSS(sideC, sideB, sideA);
                    angleAC = q4.getAngleBySSS(sideC, sideA, sideB);
                    area = q4.getArea(sideA, sideB, sideC);
                    q4.displayFullOutput(sideA, sideB, sideC, angleBC, angleAC, angleAB, area);
                }
                
                break;
            }
            else if (triangle.equalsIgnoreCase("(SSS)")){
                System.out.print("Side 1: ");
                sideA = sc.nextDouble();
                System.out.print("Side 2: ");
                sideB = sc.nextDouble();
                System.out.print("Side 3: ");
                sideC = sc.nextDouble();
                if (!q4.isTriangle(sideA, sideB, sideC)||sideA<=0||sideB<=0||sideC<=0){
                    System.out.println("Triangle Info");
                    System.out.printf("Side A: %.2f\n" , sideA);
                    System.out.printf("Side B: %.2f\n" , sideB);
                    System.out.printf("Side C: %.2f\n" , sideC);
                    System.out.println("Not a Valid Triangle");
                }   
                else{
                    angleBC = q4.getAngleBySSS(sideC, sideB, sideA);
                    angleAC = q4.getAngleBySSS(sideC, sideA, sideB);
                    angleAB = q4.getAngleBySSS(sideA, sideB, sideC);
                    area = q4.getArea(sideA, sideB, sideC);
                    q4.displayFullOutput(sideA, sideB, sideC, angleBC, angleAC, angleAB, area);
                }
                break;
            }
            else{
                System.out.println("Invalid input");
            }
        }
    }
    
}
