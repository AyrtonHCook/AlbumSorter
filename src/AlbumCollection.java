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
