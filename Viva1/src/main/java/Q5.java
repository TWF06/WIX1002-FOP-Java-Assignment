
import java.util.Scanner;
import java.util.Random;

public class Q5 {
    
    public static void main (String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        //declaration
        String spacecraftName;
        double distance;
        double fuel;
        int spacecraftType;
        
        //Use while loop to allow multiple spacecraft entries
        while (true) {
            System.out.print("Enter spacecraft name (Enter 'stop' to terminate program): ");
            spacecraftName = input.nextLine();
            
            //stop the loop when user enter 'stop'
            if (spacecraftName.equalsIgnoreCase("STOP")) {
                break;
            }
            
            System.out.print("Enter distance travelled (km) (distance should be positive number): ");
            distance = input.nextDouble();
            
            //validate distance 
            while (distance <= 0) {
                System.out.println("Invalid input! Distance must be positive numbers.");
                System.out.print("Enter distance travelled (km) (distance should be greater than 0): ");
                distance = input.nextDouble();
            }
        
            System.out.print("Enter fuel used (liters)(fuel should be greater than 0): ");
            fuel = input.nextDouble();
        
            //validate fuel 
            while (fuel <= 0) {
                System.out.println("Invalid input! Fuel must be positive numbers.");
                System.out.print("Enter fuel used (liters)(fuel should be greater than 0): ");
                fuel = input.nextDouble();
            }
        
            System.out.print("Select spacecraft type (1-Rocket, 2-Shuttle, 3-Probe): ");
            spacecraftType = input.nextInt();
            input.nextLine();
            
            //validate type 
            while (spacecraftType != 1 && spacecraftType != 2 && spacecraftType != 3) {
                System.out.println("Invalid input! Please enter 1, 2 or 3 only.");
                System.out.print("Select spacecraft type (1-Rocket, 2-Shuttle, 3-Probe): ");
                spacecraftType = input.nextInt();
                input.nextLine();
            }
                   
            System.out.println("\n");
            System.out.println("Spacecraft: " + spacecraftName);
        
            //use switch to print type
            switch (spacecraftType) {
                case 1:
                    System.out.println("Type: Rocket");
                    break;
                case 2:
                    System.out.println("Type: Shuttle");
                    break;
                case 3:
                    System.out.println("Type: Probe");
                    break;
            }
        
            //calculate and print efficiency
            double efficiency = distance / fuel;
            System.out.printf("Fuel Efficiency: %.2f", efficiency);
            System.out.println(" km/l");
             
            //use if-else to classify efficiency and print performance
            if (efficiency > 10) {
                System.out.println("Performance: Outstanding performance! Minimal fuel usage.");
            } else if (efficiency >= 5 && efficiency <= 10) {
                System.out.println("Performance: Good performance! Efficient mission.");
            } else {
                System.out.println("Performance: Needs improvement! High fuel consumption.");
            }
        
            //use random and switch to print mission tip
            Random g = new Random();
            int missionTip = g.nextInt(3);
        
            switch (missionTip) {
                case 0:
                    System.out.println("Mission Tip: Always monitor fuel ratios before takeoff!");
                    break;            
                case 1:
                    System.out.println("Mission Tip: Maintain stable engine thrust to maximize fuel efficiency across long distances.");
                    break;   
                case 2:
                    System.out.println("Mission Tip: Prioritize efficient fuel usage during interplanetary travel to reduce mission cost.");
                    break;    
            }
            System.out.println("\n");    
        }    
    }   
}
