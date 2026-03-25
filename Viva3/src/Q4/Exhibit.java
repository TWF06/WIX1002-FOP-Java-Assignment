package Q4;

public class Exhibit {
    private String title, artist, type, description;
    private int year;
    
    public Exhibit(String title, String artist, int year, String type, String description){
        this.title = title;
        this.artist = artist;
        this.year = year;
        this.type = type;
        this.description = description;
    }
    
    public String getTitle(){
        return title;
    }
    
    public String getArtist(){
        return artist;
    }
    
    public int getYear(){
        return year;
    }
    
    public String getType(){
        return type;
    }
    
    public String getDetails(){
        String details;
        details = "Title: "+ title+"\nArtist: "+artist+"\nYear: "+year+"\nType: "+type+ "\nDescription: "+description+"\n";
        return details;
    }
}
