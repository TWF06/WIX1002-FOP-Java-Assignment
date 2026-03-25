package Q1;

public class PotionContainer {
    private Potion[] potions;
    private int count;
    public PotionContainer(){
        potions = new Potion[2];
        count =0;
    }
    
    public void addPotion(String ingredient, double volume){
        if (count<potions.length){
            potions [count] = new Potion(ingredient, volume);
            System.out.println(volume+ " ml of "+ ingredient+" added to container.");
            count++;
        }
        else{
            System.out.println("The container is already full with 2 ingredients.");
        }
    }   
    
    public void usePotion(String ingredient, double volume){
        for(int i =0;i<count;i++){
            if (potions[i].getIngredient().equalsIgnoreCase(ingredient)){
                potions[i].consume(volume);
                if (potions[i].getVolume()>=volume){
                    System.out.println(volume +" ml of "+ ingredient +" is used.");
                }
                return;
            }
        }
        System.out.println(ingredient+" is not in the container");
    }
    
    public double getRemainingVolume(String ingredient){
        for(int i =0;i<potions.length;i++){
            if (potions[i].getIngredient().equalsIgnoreCase(ingredient)){
                return potions[i].getVolume();
            }
        }
        System.out.println(ingredient+" is not in the container");
        return 0;
    }
    
    public boolean isEnoughForPotion(double requiredUnicornTears, double requiredDragonBlood){
        double UT = getRemainingVolume("Unicorn Tears");
        double DB = getRemainingVolume("Dragon Blood");
        return ((UT>=requiredUnicornTears) && (DB>=requiredDragonBlood));
    }
    
    public void printPotions(){
        System.out.println("\n--- Potion Inventory ---");
        System.out.println("Unicorn Tears: "+getRemainingVolume("Unicorn Tears")+" ml");
        System.out.println("Dragon Blood: "+getRemainingVolume("Dragon Blood")+" ml");
    }
}
