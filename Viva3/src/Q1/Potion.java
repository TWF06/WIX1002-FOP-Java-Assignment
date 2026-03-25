package Q1;

public class Potion {
    private String ingredient;
    private double volume;
    
    public Potion(String ingredient, double volume){
        this.ingredient=ingredient;
        this.volume=volume;
    }
    
    public String getIngredient(){
        return ingredient;
    }
    
    public double getVolume(){
        return volume;
    }
    
    public void consume(double amount){
        if (amount<0){
            System.out.println("Invalid amount to consume!");
        }
        else if(amount>volume){
            System.out.println("Not enough "+ingredient+" available.");
        }
        else{
            volume=volume-amount;
        }
    }
}
