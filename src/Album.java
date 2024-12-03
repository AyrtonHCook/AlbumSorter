import java.util.ArrayList;
import java.util.List;
public class Album {
    private String artistName;
    private String albumName;
    private List<Track> tracks;

    public Album(String artistName, String albumName){
        this.artistName = artistName;
        this.albumName = albumName;
        this.tracks = new ArrayList<>();
    }

    public void addTrack(Track track){
        tracks.add(track);
    }
    public String getArtistName() {
        return artistName;
    }
    public String getAlbumName() {
        return albumName;
    }
    public List<Track> getTracks() {
        return tracks;
    }
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(albumName).append(" by ").append(artistName);
        for (Track track : tracks) {
            result.append("  ").append(track).append("\n");
        }
        return result.toString();
    }

}


