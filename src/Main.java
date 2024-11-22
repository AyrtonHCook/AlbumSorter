import java.io.*;

public class Main {

    public static void main(String[] args) {
        try {
            BufferedReader albumlist = new BufferedReader(new FileReader("src/albums.txt"));
            String line;
            StringBuilder timestamps = new StringBuilder();
            int albumLineNumber = 0;
            boolean firstAlbum = true;

            while ((line = albumlist.readLine()) != null) {
                line = line.trim(); // Clean up any leading/trailing spaces

                // Check if the line is an album line (based on the format "Artist : Album Title (Year)")
                if (line.contains(" : ")) {
                    // Output the previous album's data, if it's not the first album
                    if (!firstAlbum) {
                        System.out.println(albumLineNumber + "," + timestamps.toString());
                    }
                    // Reset the timestamps for the next album
                    timestamps.setLength(0);
                    albumLineNumber++;  // Increment album line number
                    firstAlbum = false; // After the first, we won't need the flag anymore
                } else if (line.contains("-")) {
                    // It's a song line with a timestamp
                    String[] parts = line.split(" - ");
                    if (parts.length > 1) {
                        String timestamp = parts[0].trim();
                        if (timestamps.length() > 0) {
                            timestamps.append(", "); // Separate timestamps with commas
                        }
                        timestamps.append(timestamp); // Add the timestamp to the list
                    }
                }
            }
            // Print the last album's data
            if (timestamps.length() > 0) {
                System.out.println(albumLineNumber + "," + timestamps.toString());
            }

            albumlist.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}