import java.util.Scanner;
public class Q1 {
    public static void main(String[]args){
        //declaration
        Scanner sc = new Scanner(System.in);
        String motivate, resting="Good to have enough rest ^.^", tip="";
        int studiedTime, sleptTime, breakTime, score;
        int tipNum;
        
        //prompt user to input, no negative value, while-loop loop when wrong input 
        while(true){
            System.out.print("Enter hours studied (input between 0 to 24): ");
            studiedTime = sc.nextInt();
            System.out.print("Enter hours slept (input between 0 to 24): ");
            sleptTime = sc.nextInt();
            System.out.print("Enter breaks taken (30 minutes is considered as 1 break, input between 0 to 10): ");
            breakTime = sc.nextInt();
            if (studiedTime<0 || sleptTime<0 || breakTime<0 || studiedTime>24 || sleptTime>24 || breakTime>10 || (studiedTime + sleptTime + (breakTime/2.0))>24 ){
                System.out.println("your input value is not allowed. Please enter again.");
            }
            else{
                break;
            }
        }
        
        //score formula
        score = (studiedTime*10)-(breakTime*5); //i use 5 instead of 2 to balance up the score, not too high if user rest a lot, question allow modify
        
        //determine message, nested if else
        if (score > 60){
            motivate = "Excellent! Keep up the great work!";
            if (sleptTime<8){
                resting = "However, try to get enough sleep ^o^";
            }
        }
        else if (score >= 30){
            motivate = "Good effort, but balance your breaks!";
            if (sleptTime<8){
                resting = "However, try to get enough sleep ^o^";
            }
        }
        else{
            motivate = "Try to plan your day better!";
            if (sleptTime<8){
                resting = "However, try to get enough sleep ^o^";
            }
        }
        
        //generate random number to choose tip of the day
        tipNum= (int)((Math.random()*(3-1+1))+1);
        
        switch(tipNum){
            case 1:{
                tip="Revise your notes before sleeping.";
                break;
            }
            case 2:{
                tip="Do past year can make you familiar with the exam questions.";
                break;
            }
            default:{
                tip="Study group can make study more efficient.";
            }
        }
        
        //output
        System.out.println("\n\nYour productivity score is "+ score);
        System.out.println(motivate);
        System.out.println(resting);
        System.out.println("Tips of the Day: "+ tip);
        
        sc.close();
    }
    
    
    
}
