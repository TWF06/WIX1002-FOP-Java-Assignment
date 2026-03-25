//Number Base Conversion(non-static method)
import java.util.Scanner;
public class Q5 {
    private static final String DIGITS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";//base 2 to 36 all here 
    
    public double convertToBaseTen(String num, int base){
        String num1=num;
        if(num.startsWith("-")){
            num1 = num.substring(1);
        }
        String[] parts = num1.split("\\.");
        String wholePart = parts[0];
        String fracPart;
        if(parts.length > 1)
            fracPart=parts[1];
        else{
            fracPart="";
        }
        double answer=0;
        for (int i = 0,j=wholePart.length()-1;j>=0;i++,j--) {
            char c = wholePart.charAt(j);
            answer=answer+(DIGITS.indexOf(c)*(int)Math.pow(base, i)); 
        }
        for (int i = 1,j=0;j<fracPart.length();i++,j++) {
            char c = fracPart.charAt(j);
            answer=answer+(DIGITS.indexOf(c)*(Math.pow(base, (-i)))); 
        }
        if(num.startsWith("-")){
            return -answer;
        }
        else
            return answer;
    }
    
    public String convertFromBaseTen(double num,int base){
        boolean isNegative = num < 0;
        if (isNegative) 
            num = -num;
        long whole = (long) num;
        double frac = num - whole;
        String wholeStr = "";
        if (whole == 0) {
            wholeStr = "0";
        } 
        else {
            String temp = "";
            while (whole > 0) {
                int digit = (int)(whole % base);
                temp = DIGITS.charAt(digit) + temp;  
                whole /= base;
            }
            wholeStr = temp;
        }
        String fracStr = "";
        int count = 0;
        while (frac > 0 && count < 8) {  // limit to 8 digits
            frac *= base;
            int digit = (int) frac;
            fracStr = fracStr + DIGITS.charAt(digit);
            frac -= digit;
            count++;
        }
        String result = wholeStr;
        if (!fracStr.equals("")) {
            result = result + "." + fracStr;
        }
        if (isNegative){
            result = "-" + result;
        }
        return result;    
    }
    
    public boolean checkValidForBase (String num, int base){
        if(num.startsWith("-")){
            num = num.substring(1);
        }
        for (char c: num.toCharArray()){
            if(c=='.'){
                continue;
            }
            int valueC = DIGITS.indexOf(c);//DIGITS already arranged from 0 to 36
            if(valueC<0 || valueC>=base){
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        Q5 q5=new Q5();
        String number;
        int fromBase,toBase;
        outer:
        while (true){
            System.out.print("Enter the number to convert:");
            number = sc.nextLine().toUpperCase();
            for (char c : number.toCharArray()){
                if (!(Character.isLetterOrDigit(c) ||c=='.'||c=='-')){
                    System.out.println("Invalid");
                    continue outer;
                }
            }
            break;
        }
        while(true){
            System.out.print("Enter the original base (2-36): ");
            fromBase = sc.nextInt();
            if ((!q5.checkValidForBase(number, fromBase)||(fromBase<2 || fromBase>36 ))){
                System.out.println("Invalid");
            }
            else{
                break;
            }
        }
        while(true){
            System.out.print("Enter the new base (2-36): ");
            toBase = sc.nextInt();
            if (toBase<2 || toBase>36 ){
                System.out.println("Invalid");
            }
            else{
                break;
            }
        }
        double numberinTen = q5.convertToBaseTen(number, fromBase);
        System.out.printf("Number %s in base %d converted to base 10 is %f %n\n",number,fromBase,numberinTen);
        String numberinBase = q5.convertFromBaseTen(numberinTen, toBase);
        System.out.printf("Number %f in base 10 converted to base %d is %s %n\n",numberinTen,toBase,numberinBase);
    }
}
