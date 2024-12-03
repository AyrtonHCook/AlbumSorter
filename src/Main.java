
import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<String[]> albumTimestamps = null;
        try {
            BufferedReader albumlist = new BufferedReader(new FileReader("src/albums.txt"));
            String line;
            albumTimestamps = new ArrayList<>();
            ArrayList<String> timestamps = new ArrayList<>(); // Temporary list to hold the timestamps for the current album
            int albumLineNumber = 0;
            boolean firstAlbum = true;

            while ((line = albumlist.readLine()) != null) {

                // Check if the line is an album title line
                if (line.contains(" : ")) {
                    //weird bug where the first alumb was skipped over, this fixed that
                    if (!firstAlbum) {
                        albumTimestamps.add(timestamps.toArray(new String[0])); // Add the current album's timestamps as an array
                    }
                    // Reset the timestamps for the next album
                    timestamps.clear();
                    albumLineNumber++;  // Increment album line number
                    firstAlbum = false; // After the first album we dont need to check  anymore
                } else if (line.contains(" - ")) {
                    // It's a song line with a timestamp
                    String[] parts = line.split(" - ");
                    if (parts.length > 1) {
                        String timestamp = parts[0].trim();
                        timestamps.add(timestamp); // Add the timestamp to the list
                    }
                }
            }
            // Print the last album's data
            if (!timestamps.isEmpty()) {
                albumTimestamps.add(timestamps.toArray(new String[0])); // Add the last albums timestamps
            }

            // Output the album numbers and their corresponding timestamps as arrays
            for (int i = 0; i < albumTimestamps.size(); i++) {
                System.out.println("Album " + (i + 1) + ": " + arrayToString(albumTimestamps.get(i)));
            }

            albumlist.close();
        } catch (IOException e) {
            e.printStackTrace();
        }



        //HUGEEEEEEEE,   this code here is asking, what timecode song 1 album 1 is
        System.out.println(albumTimestamps.get(0)[0]);
        //HUGEEEEEEEE,   this code here is asking, what timecode song 1 album 1 is




    }

    // Helper method to convert array to string format for printing
    private static String arrayToString(String[] array) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i < array.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}