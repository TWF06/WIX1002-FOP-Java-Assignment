package Q1;

public class PotionTest {
    public static void main(String[] args) {
        PotionContainer container = new PotionContainer();
        
        System.out.println("Adding potions to the container...");
        container.addPotion("Unicorn Tears", 200.0);
        container.addPotion("Dragon Blood", 150.0);
        System.out.println("Potion container successfully initialized.\n");
        
        System.out.println("=== Using Potions ===");
        container.usePotion("Unicorn Tears", 50.0);
        System.out.println("Remaining volume of Unicorn Tears: " + container.getRemainingVolume("Unicorn Tears") + " ml");
        container.usePotion("Dragon Blood", 30.0);
        System.out.println("Remaining volume of Dragon Blood: " + container.getRemainingVolume("Dragon Blood") + " ml");
        System.out.println("\nAttempting to use more Dragon Blood than available...");
        container.usePotion("Dragon Blood", 200.0);
        System.out.println("Remaining volume of Dragon Blood: " + container.getRemainingVolume("Dragon Blood") + " ml");
        System.out.println("\n=== Checking Potion Availability for Invisibility Draught ===");
        double requiredUnicornTears = 200.0;
        double requiredDragonBlood = 150.0;
        boolean readyForInvisibilityDraught =
        container.isEnoughForPotion(requiredUnicornTears, requiredDragonBlood);
        System.out.println("\nCan prepare Invisibility Draught?");
        if (readyForInvisibilityDraught) {
            System.out.println("Yes, we have enough Unicorn Tears and Dragon Blood!");
        } else {
            System.out.println("No, we do not have enough ingredients to prepare the Invisibility Draught");
        }
        System.out.println("\nFinal state of the potion container:");
        container.printPotions();
    }

}
