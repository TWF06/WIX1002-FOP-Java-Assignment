package Q3;

public class Pet {
    private String name,species,breed,healthRecord,adopterName;
    private boolean isAdopted; 
    private int age;
    
    public Pet(String name, String species, String breed, int age, String healthRecord){
        this.name = name;
        this.species = species;
        this.breed = breed;
        this.age = age;
        this.healthRecord = healthRecord;
        this.adopterName = null;
        this.isAdopted = false;
    }
    
    public String getName(){
        return name;
    }
    
    public String getSpecies(){
        return species;
    }
    
    public int getAge(){
        return age;
    }
    
    public boolean getIsAdopted(){
        return isAdopted;
    }
    
    public void adopt(String adopterName){
        if(!isAdopted){
            this.isAdopted = true;
            this.adopterName = adopterName;
            System.out.println("");
        }
        else{
            System.out.println(name+" is already adopted by "+ this.adopterName);
        }
    }
    
    public String getDetails(){
        String detail, temp;
        if(isAdopted){
            temp = "adopted";
        }
        else{
            temp = "not adopted";
        }
        detail = "PetName: "+name+"\nSpecies: "+species+"\nBreed: "+breed+"\nAge: "+age+"\nHealthRecord: "+healthRecord+"\nAdopted: "+temp+"\nAdopterName: "+adopterName+"\n";
        return detail;
    }
    
    
}
