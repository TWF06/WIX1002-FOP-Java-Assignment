//Palindrome Generator(static method)
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class Q6 {
    public static int[] freq = new int[26];// 26 only,letters a-z
    
    public static boolean canbePalindrome(String str) {
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c >= 'a' && c <= 'z') {
                freq[c - 'a']++;//treat as ascii value
            }
        }
        int oddCount = 0;
        for (int count : freq) {
            if (count % 2 != 0) {
                oddCount++;
            }
        }
        return (oddCount <= 1); // max 1 odd-count character //put in middle
    }   
    
    public static void getPossiblePalindrome(String str) {
        char middle = 0;
        String half = "";
        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 != 0) {
                middle = (char) (i + 'a'); //middle
            }
            for (int j = 0; j < freq[i] / 2; j++) {
                half = half + (char) (i + 'a'); //one side of palindrome
            }
        }
        char[] halfArr = half.toCharArray();
        String[] halfPalin;
        List<String> result = new ArrayList<>();
        boolean[] used = new boolean[halfArr.length];
        Arrays.sort(halfArr); // important to avoid duplicates
        generateUnique(halfArr, used, new StringBuilder() , result);
        halfPalin = result.toArray(new String[0]);
        System.out.println("All possible Palindrome:");
        for(String x:halfPalin){
            if(x!=null){
                System.out.print(x);
                System.out.print(middle);
                System.out.print(new StringBuilder(x).reverse());
                System.out.println();
            }
        }
    }
    
    public static void generateUnique(char[] arr, boolean[] used, StringBuilder sb, java.util.List<String> result) {
        if (sb.length() == arr.length) {
            result.add(sb.toString());
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (used[i]) 
                continue;
            if (i > 0 && arr[i] == arr[i-1] && !used[i-1]) 
                continue;

            used[i] = true;
            sb.append(arr[i]);
            generateUnique(arr, used, sb, result);
            sb.deleteCharAt(sb.length() - 1);
            used[i] = false;
        }
    }
    
    public static void main (String[]args){
        Scanner sc = new Scanner(System.in);
        String str;
        outer:
        while(true){
            System.out.println("Enter a word: ");
            str = sc.next().toLowerCase();
            for (char c : str.toCharArray()){
                if (!Character.isLetter(c)){
                    System.out.println("Invalid");
                    continue outer;
                }
            }
            break;
        }
        System.out.println("Can be palindrome?");
        if (canbePalindrome(str)){
            getPossiblePalindrome(str);
        }
        else{
            System.out.println(">Cannot be palindrome");
        }
    }
}