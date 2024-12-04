import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
public class AlbumCollection {
    private List<Album> albums;

    public AlbumCollection(){
        this.albums = new ArrayList<>();
    }
    public void addAlbum(Album album) {
        albums.add(album);
    }
    public void sortAlbums() {
        albums.sort(Comparator.comparing(Album::getArtistName) //this bit sorts by artist name
                .thenComparing(Album::getReleaseYear));//if name is the same then sort by release year smaller to bigger
    }
    public Album getShortestAlbumName() {
        if (albums.isEmpty()) {
            return null;
        }

        Album shortestAlbum = albums.get(0);
        for (Album album : albums) {
            if (album.getAlbumName().length() < shortestAlbum.getAlbumName().length()) {
                shortestAlbum = album;
            }
        }
        return shortestAlbum;
    }
    public Track getLongestTrack() {
        if (albums.isEmpty()) {
            return null;
        }

        Track longestTrack = null;
        for (Album album : albums) {
            for (Track track : album.getTracks()) {
                if (longestTrack == null || track.getDuration().compareTo(longestTrack.getDuration()) > 0) {
                    longestTrack = track;
                }
            }
        }
        return longestTrack;
    }
    public Duration getTotalDuration(String artistName) {
        Duration totalDuration = new Duration(0,0,0);
        for (Album album : albums) {
            if (album.getArtistName().equals(artistName)) {
                for (Track track : album.getTracks()) {
                    totalDuration = totalDuration.add(track.getDuration());
                }
            }
        }
        return totalDuration;
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Album album : albums) {
            sb.append(album).append("\n");
        }
        return sb.toString();
    }
}
