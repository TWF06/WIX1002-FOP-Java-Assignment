package Q3;

public class PetAdoptionTest {
    public static void main(String[] args) {
        PetAdoptionCentre centre = new PetAdoptionCentre();

        // Adding pets to the centre
        centre.addPet(new Pet("Buddy", "Dog", "Labrador", 3, "Healthy"));
        centre.addPet(new Pet("Whiskers", "Cat", "Siamese", 2, "Vaccinated"));
        centre.addPet(new Pet("Spike", "Parrot", "Macaw", 4, "Needs checkup"));

        // Viewing available pets
        System.out.println("Available pets:");
        centre.viewAvailablePets();
 
        // Adopter matching and adoption process
        Adopter adopter1 = new Adopter("John", "Dog", "1-4");
        System.out.println("\nMatching pets for John:");
        adopter1.viewMatchingPets(centre);

        System.out.println("\nJohn adopts Buddy:");
        centre.adoptPet(centre.getPetByName("Buddy"),adopter1);
        System.out.println("\nAvailable pets after adoption:");
        centre.viewAvailablePets();
    }
}
