package Q3;

public class Adopter {
    private String name, preferredSpecies, preferredAgeRange;
    private int minAge, maxAge;
    
    public Adopter(String name, String preferredSpecies, String preferredAgeRange){
        this.name= name;
        this.preferredSpecies = preferredSpecies;
        this.preferredAgeRange = preferredAgeRange;
        String range[] = preferredAgeRange.split("-");
        this.minAge = Integer.parseInt(range[0]);
        this.maxAge = Integer.parseInt(range[1]);
    }
    
    public String getName(){//adoptername
        return name;
    }
    
    public void viewMatchingPets(PetAdoptionCentre centre){
        Pet[] pets = centre.getPets();
        int count = centre.getPetCount();
        
        for(int i = 0;i<count; i++){
            Pet p = pets[i];
            if(!p.getIsAdopted()&&p.getSpecies().equalsIgnoreCase(preferredSpecies)&&p.getAge()>=minAge&&p.getAge()<=maxAge){
                System.out.println(p.getDetails());
            }
        }
    }
}
