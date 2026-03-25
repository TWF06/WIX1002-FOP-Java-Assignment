package Q2;

public class Creature {
    private String species;
    private double magicPower;
    private String habitat;
    
    public Creature(String species, double magicPower, String habitat){
        this.species = species;
        this.magicPower = magicPower;
        this.habitat = habitat;
    }
    
    public void feed(double foodAmount){
        magicPower = magicPower+foodAmount;
        System.out.print(species+"'s magic power increased to ");
        System.out.printf("%.1f \n", magicPower);
    }
    
    public void displayInfo(){
        System.out.println("Species: "+ species);
        System.out.printf("Magic Power: %.1f \n",magicPower);
        System.out.println("Habitat: "+habitat);
        System.out.println("");
    }
    
    public String getSpecies(){
        return species;
    }
    
    public double getMagicPower (){
        return magicPower;
    }
    
    public String getHabitat(){
        return habitat;
    }
}
