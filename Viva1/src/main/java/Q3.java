import java.util.Scanner;

public class Q3 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String[] binary = new String[20];    
        int[] decimals = new int[20];       
        int count = 0;                      

        System.out.println("Enter binary code (type 'STOP' to finish):");

        //using while to ensure max 20 binary codes per run
        while(count < 20) 
        {
            String bi = s.nextLine();

            if(bi.equalsIgnoreCase("STOP")) 
            {
                System.out.println("\n");
                break;
            }
            
            boolean value = true;
            //check if binary contains only 0 and 1 , or including other characters
            for(int i = 0; i < bi.length(); i++) 
            {
                char c = bi.charAt(i);
                if(c != '0' && c != '1') 
                {
                    System.out.println("Invalid code: must contain only 0s and 1s. ");
                    value = false;
                    break;
                }
            }
            
            if(!value)
            {
                continue;
            }

            //convert binary to decimal
            int dec = 0;
            for(int i = 0; i < bi.length(); i++) 
            {
                char c = bi.charAt(bi.length() - 1 - i);
                if(c == '1')
                {
                    dec += (int)Math.pow(2, i); 
                }
            }

            binary[count] = bi;
            decimals[count] = dec;
            count++;
        }

        int sumIM = 0;
        int sumCA = 0;
        int iMCount = 0;
        int cACount = 0;

        // Divide the code to 2 diff team based on even and odd decimals
        for(int i = 0; i < count; i++) 
        {

            if(decimals[i] % 2 == 0) 
            {  
                System.out.printf("Code %s -> Decimal %d -> Iron Man's Team\n", binary[i], decimals[i]);
                sumIM += decimals[i];
                iMCount++;
            } 
            else 
            {
                System.out.printf("Code %s -> Decimal %d -> Captain America's Team\n", binary[i], decimals[i]);
                sumCA += decimals[i];
                cACount++;
            }
        }
        
        //Print output (total codes in each team & avg)
        if(iMCount > 0) 
        {
            System.out.printf("\nIron Man Team: %d codes | Average Power: %.2f\n", iMCount, (double)sumIM / iMCount);
        } 
        else 
        {
            System.out.println("\nIron Man Team: 0 codes | Average Power: 0");
        }

        if(cACount > 0) 
        {
            System.out.printf("Captain America Team: %d codes | Average Power: %.2f\n",cACount, (double)sumCA / cACount);
        } 
        else 
        {
            System.out.println("Captain America Team: 0 codes | Average Power: 0");
        }

        System.out.println("Mission Accomplished: Message Decrypted! ");
    }
}
