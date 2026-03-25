package Q4;
public class Testing {
    public static void main(String[] args) {
        Museum museum = new Museum();
        museum.loadExhibits("Exhibits.txt");

        System.out.println("All exhibits:");
        museum.viewAllExhibits();

        System.out.println("\nSearch exhibits by artist 'Vincent van Gogh':");
        museum.searchExhibitsByArtist("Vincent van Gogh");

        System.out.println("\nSearch exhibits by type 'Painting':");
        museum.searchExhibitsByType("Painting");

        System.out.println("\nSearch exhibits by year '1504':");
        museum.searchExhibitsByYear(1504);

    }
}
