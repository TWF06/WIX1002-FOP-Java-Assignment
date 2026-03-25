package Q4;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
public class Museum {
    private ArrayList<Exhibit> exhibits = new ArrayList<>();
    
    public void loadExhibits(String filename){
        try{
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            String a;
            while((a = br.readLine())!=null){
                String title = a;
                String artist = br.readLine();
                int year = Integer.parseInt(br.readLine());
                String type =br.readLine();
                String description = br.readLine();
                exhibits.add(new Exhibit(title,artist,year,type,description));
            }
            br.close();
        }catch(IOException e){
            System.out.println("File error");
            e.printStackTrace();
        }
    }
    
    public void searchExhibitsByArtist(String artist){
        for (Exhibit e:exhibits){
            if(e!=null && e.getArtist().equalsIgnoreCase(artist)){
                System.out.println(e.getDetails());
            }
        }
    }
    
    public void searchExhibitsByType(String type){
        for (Exhibit e:exhibits){
            if(e!=null && e.getType().equalsIgnoreCase(type)){
                System.out.println(e.getDetails());
            }   
        }
    }
    
    public void searchExhibitsByYear(int year){
        for (Exhibit e:exhibits){
            if(e!=null && (e.getYear()==year)){
                System.out.println(e.getDetails());
            }
        }
    }
    
    public void viewAllExhibits(){
        for (Exhibit e:exhibits){
            if(e!=null){
                System.out.println(e.getDetails());
            }
        }
    }
}
