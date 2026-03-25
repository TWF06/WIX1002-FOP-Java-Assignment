package Q2;


public class Zoo {
    private Creature []CreaInZoo;
    private int counter;
    
    public Zoo(int space){
        CreaInZoo = new Creature[space];
        counter = 0;
    }
    
    public void addCreature(String species, double magicPower, String habitat){
        if(counter<CreaInZoo.length){
            CreaInZoo[counter] = new Creature(species, magicPower, habitat);
            System.out.println(species+" added to the zoo.");
            counter++;
        }
        else{
            System.out.println("Zoo is full! Cannot add more creatures.");
        }
    }
    
    public void feedCreature (String species, double foodAmount){
        for(int i =0 ; i<counter; i++){
            if (CreaInZoo[i].getSpecies().equalsIgnoreCase(species)){
                CreaInZoo[i].feed(foodAmount);
                return;
            }
        }
        System.out.println("Creature not exist!");
    }
    
    public void displayAllCreatures(){
        for(Creature a : CreaInZoo){
            if(a!=null)
                a.displayInfo();
        }
    }
}
