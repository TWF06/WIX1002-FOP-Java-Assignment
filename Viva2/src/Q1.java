//Nearest Prime Number Finder(static method)
import java.util.Scanner;
public class Q1 {
    //method to check prime status and return boolean
    public static boolean isPrime(int num){
        if (num==2){
            return true;  
        }
        else if (num<=1||num%2==0){
            return false;
        }
        else{
            for (int i = 3; i*i<=num; i+=2){
                if (num%i==0){
                    return false;
                }
            }
            return true;
        }
    }
    //method to get nearest prime, and if two prime same distance, will automatic return smaller one
    public static int getNearestPrime(int num){
        int i=1; 
        do{
            if (isPrime(num-i)){
                return (num-i);
            }
            else if (isPrime(num+i)){
                return (num+i);
            }
            i++; 
        }while(true);
    }
     
    public static void main(String []args){
        Scanner sc = new Scanner (System.in);
        System.out.println("Enter a number to determine nearest prime.");
        int num = sc.nextInt();
        if (isPrime(num)){
            System.out.println("The number you entered, "+num+" is already a prime number.");
        }
        else{
            System.out.println("The nearest prime number from your number, "+num+" is "+ getNearestPrime(num));
        }
    }
}
