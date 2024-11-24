
public class Main {

    public static void main(String[] args) { // Duration test
        Duration d1 = new Duration(1,2,3);
//        Duration d2 = new Duration(2,3,4);
//        Duration d3 = new Duration(3,4,5);
//        System.out.println(d1.compareTo(d2));
//        System.out.println(d1.toSeconds());
        Track t1 = new Track("Rock", d1);
        Track t2 = new Track("James2", d1);
        Track t3 = new Track("James3", d1);
//        System.out.println(t1);
//        System.out.println("Should print Duration" + t1.getDuration());
//        System.out.println("Should print Title" + t1.getTitle());
        Album a1 = new Album("James", "JamesAlbum");
        a1.addTrack(t1);
        a1.addTrack(t2);
        a1.addTrack(t3);
        System.out.println("Should print out Album with track 1 " + a1);
        System.out.println(a1.getAlbumName());
        System.out.println(a1.getTracks());
        System.out.println(a1.getArtistName());

    }
}