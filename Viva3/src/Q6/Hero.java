package Q6;

public class Hero {
    private String name, element;
    private double hp, attack;
    
    public Hero(String name, String element, double hp, double attack){
        this.name=name;
        this.element=element;
        this.hp=hp;
        this.attack=attack;
    }
    
    public String getName(){
        return name;
    }
    
    public String getElement(){
        return element;
    }
    
    public double getHp(){
        return hp;
    }
    
    public double getAttack(){
        return attack;
    }
    
    public double calculateDamage(Villain enemy, int rsMultiplier){
        double dominance = getMultiplier(element, enemy.getElement());
        double damage = attack * dominance * rsMultiplier - enemy.getDefense();
        if(damage<1)
            damage=1;
        return damage;
    }
    
    public String toString() {
        return "Name: " + name + "\nElement: " + element +"\nHP: " + hp + "\nAttack: " + attack + "\n";
    }
    
    public double getMultiplier(String hero, String enemy) {
        if ((hero.equals("Water") && enemy.equals("Fire")) ||
            (hero.equals("Fire") && enemy.equals("Earth")) ||
            (hero.equals("Earth") && enemy.equals("Water")) ||
            (hero.equals("Light") && enemy.equals("Dark")) ||
            (hero.equals("Dark") && enemy.equals("Light")))
            return 1.5;
        else if (hero.equals(enemy)||(hero.equals("Fire") && (enemy.equals("Light") || enemy.equals("Dark"))) ||
        (hero.equals("Water") && (enemy.equals("Light") || enemy.equals("Dark"))) || (hero.equals("Earth") && (enemy.equals("Light") || enemy.equals("Dark"))) ||
        (hero.equals("Light") && (enemy.equals("Water") || enemy.equals("Fire") || enemy.equals("Earth"))) || (hero.equals("Dark") && (enemy.equals("Water") || enemy.equals("Fire") || enemy.equals("Earth")))){
            return 1.0;
        }
        else{
            return 0.5;
        }
    }
}
