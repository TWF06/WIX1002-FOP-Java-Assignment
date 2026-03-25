package Q3;

public class PetAdoptionCentre {
    private Pet []pets ;
    private int petCount;
    
    public Pet[] getPets(){
        return pets ;
    }
    
    public int getPetCount(){
        return petCount;
    } 
    
    public PetAdoptionCentre(){
        pets = new Pet[10];
        petCount=0;
    }
    
    public void addPet(Pet pet){
        if(petCount<pets.length){
            pets[petCount]=pet;
            petCount++;
        }
        else{
            System.out.println("Centre is full.");
        }
    }
    
    public void adoptPet(Pet pet,Adopter adopter) {
        if(pet!=null && !pet.getIsAdopted()){
            pet.adopt(adopter.getName());
        }        
    }
    
    public void viewAvailablePets(){
        for (int i=0;i<petCount; i++){
            for (int j=0; j<petCount-1;j++){
                if (pets[j].getAge()>pets[j+1].getAge()){
                    Pet temp = pets[j+1];
                    pets[j+1]= pets[j];
                    pets[j]=temp;
                }
            }
        }
        for(Pet p: pets){
            if(p!=null&&!p.getIsAdopted()){
                System.out.println(p.getDetails());
            }
        }
    }
    
    public Pet getPetByName(String petName){
        for(Pet p: pets){
            if(p!=null&&p.getName().equalsIgnoreCase(petName))
            return p;
        }
        return null;
    }
}
