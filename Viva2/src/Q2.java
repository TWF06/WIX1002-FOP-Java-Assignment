//Message Encoder(static method)
import java.util.Scanner;
import java.util.Random;
public class Q2 {
    //method to insert random symbol character
    public static String insert(String str){
        Random r = new Random();
        char []specialSymbol = {'@', '#', '$'};
        int oriLength = str.length();
        char []insertedStr = new char[2*oriLength];
        for (int i = 0, j=0; i<insertedStr.length; i+=2, j++){
            insertedStr[i]=str.charAt(j);
            insertedStr[i+1]=specialSymbol[r.nextInt(specialSymbol.length)];
        }
        String result = new String(insertedStr);
        return result;
    }
    //method to break and shuffle
    public static String breakAndFlip(String str){
        char []joinedStr = new char [str.length()];
        if (str.length()%2==0){//length is even
            int half = str.length()/2;  // 0 1 2 3 4 5 (example 6 char in string)
            char []strLeft = new char[half];//012 go here <half
            char []strRight = new char[half];//345 go here >half
            for (int i=0, j=half-1, k=str.length()-1; k>=half; i++,j--,k--){//flipped here
                strLeft[i]=str.charAt(j);
                strRight[i]=str.charAt(k);
            }
            for (int i=0, j=0, k=half; i<half; i++,j++,k++){
                joinedStr[j] = strLeft[i];
                joinedStr[k] = strRight[i];
            }
        }
        else{//length is odd
            int half =  str.length()/2;// 0 1 2 3 4 5 6 (example 7 char in string)//3 go here stay remain unchanged
            char []strLeft = new char[half];//012 go here <half
            char []strRight = new char[half];//456 go here >half
            for (int i=0, j=half-1, k=str.length()-1; k>half; i++,j--,k--){//flipped here
                strLeft[i]=str.charAt(j);
                strRight[i]=str.charAt(k);
            }
            joinedStr[half]=str.charAt(half);
            for (int i=0, j=0, k=half+1; i<half; i++,j++,k++){
                joinedStr[j] = strLeft[i];
                joinedStr[k] = strRight[i];
            }
        }
        String result = new String(joinedStr);
        return result;
    }
    
    public static String shift (String str){
        char []shiftStr = str.toCharArray();
        for (int i =0 ; i< shiftStr.length;i++){
            char temp = shiftStr[i];
            if (Character.isUpperCase(temp))
                shiftStr[i] = (char)(temp+2+i);
            else if (Character.isLowerCase(temp))
                shiftStr[i] = (char)(temp+3+i);
            else if (Character.isDigit(temp))
                shiftStr[i] = (char)(temp+10+i);
        }
        String result = new String(shiftStr);
        return result;
    }
    
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter message: ");
        String str = sc.nextLine();
        String step1,step2,step3;
        step1 = insert(str);
        step2 = breakAndFlip(step1);
        step3 = shift(step2);
        System.out.println("Step 1 (add symbol): "+ step1);
        System.out.println("Step 2 (break and shuffle): "+ step2);
        System.out.println("Step 3 (shift): "+ step3);
        
//        System.out.println("checking functionality 1  "+ insert(str));
//        System.out.println("checking functionality 2  "+ breakAndFlip(str));
//        System.out.println("checking functionality 3  "+ shift(str));   
    }
}
/*
dec oct  hex   char
48  060	30	0
	
49  061	31	1
	
50  062	32	2
	
51  063	33	3
	
52  064	34	4
	
53  065	35	5
	
54  066	36	6
	
55  067	37	7
	
56  070	38	8
	
57  071	39	9
	
58  072	3A	:
	
59  073	3B	;
	
60  074	3C	<
	
61  075	3D	=
	
62  076	3E	>
	
63  077	3F	?
	
64  100	40	@
	
65  101	41	A
	
66  102	42	B

67  103	43	C
*/