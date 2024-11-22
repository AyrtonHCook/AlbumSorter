public class Track {
    public static void main(String[] args) {
        Duration d1 = new Duration(1,2,3);
        Duration d2 = new Duration(2,3,4);
        Duration d3 = new Duration(3,4,5);
        System.out.println(d1.compareTo(d2));
        System.out.println(d1.toSeconds());

    }

}
