import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        AlbumCollection collection = new AlbumCollection();
        System.out.println("Working Directory: " + System.getProperty("user.dir"));
        try (BufferedReader br = new BufferedReader(new FileReader("albums.txt"))) {
            String line;
            Album currentAlbum = null;

            while ((line = br.readLine()) != null) {

                if (line.contains(" : ")) {
                    String[] parts = line.split(":");
                    String artist = parts[0].trim();
                    String[] albumParts = parts[1].split("\\(");

                    String albumTitle = albumParts[0].trim();
                    int year = Integer.parseInt(albumParts[1].replace(")", "").trim());
                    currentAlbum = new Album(artist, albumTitle, year);
                    collection.addAlbum(currentAlbum);

                } else if (line.startsWith("0:")) {
                    String[] parts = line.split(" - ");
                    String[] durationParts = parts[0].split(":");
                    int minutes = Integer.parseInt(durationParts[1]);
                    int seconds = Integer.parseInt(durationParts[2]);
                    Duration duration = new Duration(0, minutes, seconds);
                    String trackTitle = parts[1].trim();
                    if (currentAlbum != null) {
                        currentAlbum.addTrack(new Track(trackTitle, duration));
                    }
                }
            }

            System.out.println("Unsorted collection of albums\n" + collection);
            System.out.println("Kraftwarks total duration " + collection.getTotalDuration("Kraftwerk"));
            collection.sortAlbums();
            System.out.println("\nAlbums sorted by artist and release year:\n" + collection);
            System.out.println("\nShortest Album name: " + collection.getShortestAlbumName().getAlbumName());
            System.out.println("\nLongest Track in collection: " + collection.getLongestTrack());

        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}