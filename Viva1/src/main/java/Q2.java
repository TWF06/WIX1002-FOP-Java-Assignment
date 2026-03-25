import java.util.Scanner;
public class Q2 {
    public static void main(String[]args){
        //declaration
        Scanner sc= new Scanner(System.in);
        double litres;
        outerloop:
        while(true){
        String cusType;
        double bill=0;
        
        //while-loop prompt user to input and loop if wrong input
        loop1:
        while(true){
            while(true){
                System.out.print("Customer Type (residential or commercial): ");
                cusType = sc.next();
                if (!cusType.equalsIgnoreCase("residential") && !cusType.equalsIgnoreCase("commercial")){
                    System.out.println("Invalid input. Please enter again.");
                    continue;
                }
            break;
            }
            System.out.print("Liters Used (input between 0 to 50000, enter 0 to quit program): ");
            litres = sc.nextDouble();
            if (litres == 0)
                break outerloop;
            if(litres < 0 || litres > 50000){
                System.out.println("Invalid input. Please enter again.");
            }
            else{
                break loop1;
            }
        }
        
        //calculation using method
        if (cusType.equalsIgnoreCase("residential")){
            bill = Residential(litres);
        }
        else if (cusType.equalsIgnoreCase("commercial")){
            bill = Commercial(litres);
        }
        
        //Display output
        if (cusType.equalsIgnoreCase("residential")){
            System.out.println("\nCustomer Type: Residential");
        }
        else if (cusType.equalsIgnoreCase("commercial")){
            System.out.println("\nCustomer Type: Commercial");
        }
        System.out.print("Water Usage: " + (int)litres + " L");
        System.out.printf("\nTotal Bill: RM%.2f",bill);
        System.out.println("\nThank you for conserving water!\n\n\n");
        }
    }
    
    //residential calculation method
    public static double Residential(double litres){
        double L = litres;
        double rate;
        if (L<=1000.0){
            rate = 0.02;
        }
        else if (L<=5000){
            rate = 0.05;
        }
        else{
            rate =0.08;
        }
        return (L*rate);
    }
    
    //commercial calculate method
    public static double Commercial(double litres){
        double L = litres;
        double rate;
        if (L<=10000.0){
            rate = 0.06;
        }
        else{
            rate =0.10;
        }
        return (L*rate);
    }
}
