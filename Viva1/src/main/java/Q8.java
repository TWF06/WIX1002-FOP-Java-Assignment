
import java.util.Scanner;
import java.util.Random;

public class Q8 {
    
    public static void main (String[] args) {
        
        Scanner input = new Scanner(System.in);
 
        //declaration
        int steps;
        int totalSteps = 0;
        int highestSteps = 0;
        int mostActiveDay = 0; 
        
        //use for loop to prompt user enter number of steps for 7 days
        for (int i = 1; i <= 8; i++) {
            System.out.print("Enter steps for Day " + i + " (steps should be between 0 to 50000): ");
            steps = input.nextInt();
            
            //validate steps 
            while (steps < 0 || steps > 50000) {
                System.out.println("Invalid input! Please enter a number between 0 and 50000");
                System.out.print("Enter steps for Day " + i + " (steps should be between 0 to 50000): ");
                steps = input.nextInt();
            }
            
            //calculate total steps
            totalSteps += steps;
            
            //calculate highest steps and most active day
            if (steps > highestSteps) {
                highestSteps = steps;
                mostActiveDay = i;
            }
        }
        
        //print output
        System.out.println("\n");
        System.out.println("Total Steps This Week: " + totalSteps);
        
        double averageDailySteps = (double) totalSteps / 8;
        System.out.printf("Average Daily Steps: %.2f", averageDailySteps);
        
        System.out.println("\nMost Active Day: Day " + mostActiveDay + " with " + highestSteps + " steps");        
       
        //use if else to print motivational message based on total steps
        if (totalSteps >= 70000) {
            System.out.println("Amazing! You're smashing your goals!");
        } else if (totalSteps >= 40000 && totalSteps <= 69999) {
            System.out.println("Good job! Keep pushing for consistency!");
        } else {
            System.out.println("You can do better, small steps daily make a big difference!");
        }
        
        //use random and switch to print tip
        Random g = new Random();
        int healthTipOfTheDay = g.nextInt(3);
        
        switch (healthTipOfTheDay) {
            case 0: 
                System.out.println("Tip of the Day: Stay hydrated and stretch after walks!");
                break;   
            case 1: 
                System.out.println("Tip of the Day: Take the stairs instead of the elevator today.");
                break;   
            case 2: 
                System.out.println("Tip of the Day: Set small step goals to stay motivated throughout the day.");
                break;     
        }
    }   
}
