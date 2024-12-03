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
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Album album : albums) {
            sb.append(album).append("\n");
            for (Track track : album.getTracks()) {
                sb.append("  ").append(track).append("\n");
            }
        }
        return sb.toString();
    }
}
