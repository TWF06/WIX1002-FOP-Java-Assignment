package Q6;

public class Villain {
    private String name, element;
    private double maxHp,hp,attack, defense;
    private int initialCd, currentCd;
    
    public Villain(String name, String element, double maxHp, double attack, double defense, int cd) {
        this.name = name;
        this.element = element;
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.attack = attack;
        this.defense = defense;
        this.initialCd = cd;
        this.currentCd = cd;
    }
    
    public String getName() { 
        return name; 
    }
    
    public String getElement() { 
        return element; 
    }
    
    public double getDefense() { 
        return defense; 
    }
    
    public double getHp() { 
        return hp; 
    }
    
    public int getCurrentCd() { 
        return currentCd; 
    }
    
    public double getAttack() { 
        return attack; 
    }
    
    
    public void getDamaged(double damage){
        hp-=damage;
        if(hp<0)
            hp=0;
    }
    
    public void resetHp() { 
        hp = maxHp; 
    }
    
    public void decreaseCd() { 
        currentCd--; 
    }
    
    public void resetCd() { 
        currentCd = initialCd; 
    }

    
    public String toString() {
        return "Enemy: " + name + " \nHP: " + hp + " \nCD: " + currentCd;
    }
}
