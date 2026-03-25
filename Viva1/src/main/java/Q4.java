
import java.util.Random;
import java.util.Scanner;

public class Q4 {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int num;

        // Ask user to enter a number
        do 
        {
            System.out.print("Enter a non-negative number 0-20: ");
            num = s.nextInt();

            if (num < 0 || num > 20) 
            {
                System.out.println("Invalid input! Please enter a number between 0 and 20.");
            }

        } while (num < 0 || num > 20);   

        //factorial computation
        long fac = 1;
        for (int i = 1; i <= num; i++) 
        {
            fac *= i;
        }

        //check validity of mode
        int mode;
        do 
        {
            System.out.print("Choose mode (1-Combinatorics, 2-Security, 3-Game): ");
            mode = s.nextInt();

            if (mode < 1 || mode > 3) 
            {
                System.out.println("Invalid input! Please enter 1, 2 or 3.");
            }

        } while (mode < 1 || mode > 3);

        System.out.printf("\n\nFactorial of %d is %d \n", num, fac);

        // using switch to print output of mode based on user choice.
        switch (mode) 
        {
            case 1:
                System.out.println("In Combinatorics Mode: There are " + fac + " ways to arrange " + num + " unique items.");
                break;
            case 2:
                System.out.println("In Security Mode: You can create " + fac + " unique password combinations using " + num + " characters.");
                break;
            case 3:
                System.out.println("In Game Mode: There are " + fac + " unique levels that can be made from " + num + " elements.");
                break;
        }

        // using random to print tip of the day
        Random r = new Random();
        int tips = r.nextInt(3);

        switch (tips)
        {
            case 0:
                System.out.println("Tip of the Day: Factorials grow very fast; optimize your code for efficiency!");
                break;
            case 1:
                System.out.println("Tip of the Day: Factorials grow very fast, just as your knowledge.");
                break;
            case 2:
                System.out.println("Tip of the Day: Factorials grow very fast, just as your path to succeed as well.");
                break;
        }
    }
}
