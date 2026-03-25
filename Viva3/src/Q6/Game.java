package Q6;
import java.util.Random;

public class Game {

    public void battle(Team team, Villain enemy) {

        // Reset HP and cooldown before battle
        team.resetTeamHp();
        enemy.resetHp();
        enemy.resetCd();

        Random rand = new Random();
        String[] elements = {"Water", "Fire", "Earth", "Light", "Dark"};

        int round = 1;

        while (team.getHp() > 0 && enemy.getHp() > 0) {

            System.out.println("\nRound " + round);
            System.out.println("Enemy's current CD: " + enemy.getCurrentCd());
            
            String[] runestones = new String[3];
            System.out.println("Runestones dissolved:");
            for (int i = 0; i < 3; i++) {
                runestones[i] = elements[rand.nextInt(5)];
                System.out.println("- " + runestones[i]);
            }
            System.out.println("");
            boolean gotAttack=false;
            for (Hero h : team.getHeroes()) {
                int rsMultiplier = 0;

                for (int i = 0; i < 3; i++) {
                    if (runestones[i].equals(h.getElement())) {
                        rsMultiplier++;
                    }
                }

                if (rsMultiplier > 0 && enemy.getHp() > 0) {
                    double damage = h.calculateDamage(enemy, rsMultiplier);
                    enemy.getDamaged(damage);
                    gotAttack=true;
                    System.out.println(h.getName() +" dealt " + damage + " damage to " + enemy.getName());
                }
            }
            
            if(!gotAttack){
                System.out.println("No hero attacked in this round.");
            }
            
            if (enemy.getCurrentCd() == 1 && enemy.getHp() > 0) {
                team.getDamaged(enemy.getAttack());
                System.out.println(enemy.getName() +" dealt " + enemy.getAttack() + " damage to the team");
                enemy.resetCd();
            } 
            else if(enemy.getCurrentCd() > 1){
                    enemy.decreaseCd();
            }


            System.out.println("\nTeam's remaining HP: " + team.getHp());
            System.out.println("Enemy's remaining HP: " + enemy.getHp());

            round++;
        }


        if (team.getHp() > 0) {
            System.out.println("\nThe team won!");
        } 
        else {
            System.out.println("\nThe team lose.");
        }
    }
}