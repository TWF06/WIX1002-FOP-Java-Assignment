package Q6;
import java.util.Random;
public class Team {
    private Hero[]deck;
    private Hero[]heroList = new Hero[4];
    private double hp;
    
    public Hero[] getHeroes() { 
        return heroList; 
    }
    
    public double getHp(){ 
        return hp; 
    }
    
    public Team(Hero[]deck){
        this.deck=deck;
    }
    
    public void formTeam() {
    Random r = new Random();
    hp = 0;
    int i = 0;

    while (i < 4) {
        Hero temp = deck[r.nextInt(deck.length)];
        boolean duplicate = false;
        for (int j = 0; j < i; j++) {
            if (heroList[j] == temp) {
                duplicate = true;
                break;
            }
        }
        if (!duplicate) {
            heroList[i] = temp;
            hp += temp.getHp();
            i++;
        }
    }
}
    
    public void getDamaged(double damage){
        hp -= damage;
        if (hp < 0) 
            hp = 0;
    }
    
    public void resetTeamHp(){
        hp = 0;
        for (Hero h : heroList){
            hp += h.getHp();
        }
    }
    
    public String toString() {
        String s = "Team's HP: " + hp + "\n\n";
        for (int i = 0; i < heroList.length; i++)
            s += "Hero " + (i + 1) + "\n" + heroList[i] + "\n";
        return s;
    }   
    
}
