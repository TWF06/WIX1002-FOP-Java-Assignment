//Mean Adjustment(non-static method)
import java.util.Scanner;
public class Q3 {
    //i use this numLoop to control number of element to count mean, each loop execute means 1 element deleted, 
    public static int numLoop=0;
    
    public double getMean(double[]numbers){
        double sum = 0.0;
        for(int i=0; i<numbers.length;i++){
            sum=sum+numbers[i];
        }
        return sum/(numbers.length-numLoop);
        
    }
    
    public int getBestRemovealIndex(double []numbers, double targetMean){
        double bestDiff = Double.MAX_VALUE;
        int indexRemove=-1;
        double []temp = new double [numbers.length]; 
        for(int i=temp.length-1;i>=0;i--){
            for(int j=0; j<temp.length;j++){
                temp[j]=numbers[j];
            }
            temp[i]=0;
            double newMean = getMean(temp);
            if (Math.abs(targetMean-newMean)<bestDiff){
                    bestDiff=Math.abs(targetMean-newMean);
                    indexRemove=i;
            }         
        }
        return indexRemove;
    }
    
    public double getDifference (double []numbers, double targetMean){
        Q3 q3 = new Q3();
        double mean = q3.getMean(numbers);
        if (mean>targetMean)
            return (mean-targetMean);
        else
            return (targetMean-mean);
    }
    
    public static void main (String []args){
        Q3 q3 = new Q3();
        Scanner sc = new Scanner(System.in);
        int noSample, maxRemove;
        System.out.print("Enter number of samples and maximum samples to remove: ");
        while(true){
            noSample = sc.nextInt();
            maxRemove=sc.nextInt();
            if (noSample>0 && maxRemove>0 && maxRemove<noSample)
                break;
            else
                System.out.println("Both number of samples and maximum samples to remove need to be positive integers, and maximum samples to remove < number of samples. Enter again:");
        }
        System.out.print("Enter target mean: ");
        double targetMean = sc.nextDouble();
        
        double []numberSet = new double[noSample];
        System.out.println("Enter samples: ");
        for(int i = 0; i<numberSet.length; i++){
            numberSet[i]=sc.nextDouble();
        }
        
        double mean = q3.getMean(numberSet); 
        
        for(int i = 1; i<=maxRemove; i++){
            if(mean==targetMean){
                System.out.println("No extra remove required.");
                break;
            }
            else{
                numLoop++;
                int index = q3.getBestRemovealIndex(numberSet, targetMean);
                if (index==-1){
                    System.out.println("Error in method remove index.");
                }
                else{
                    System.out.printf("Removed %.1f ,", numberSet[index]);
                    numberSet[index]=0;
                    mean = q3.getMean(numberSet); 
                    System.out.printf(" new mean : %.2f \n",mean);
                }
            }   
        }
        System.out.printf("Final mean: %.2f \n",mean);
        System.out.printf("Difference with target mean: %.2f \n", q3.getDifference(numberSet, targetMean));

    }
}
