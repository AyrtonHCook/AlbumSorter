public class Duration implements Comparable<Duration> {
    private int hours;
    private int minutes;
    private int seconds;
    public Duration(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }
    public int toSeconds(){
        return(hours * 3600 + minutes * 60 + seconds);
    }
    public int compareTo(Duration other) {
        return (Integer.compare(this.toSeconds(), other.toSeconds()));
    }

    public String toString() {

    }


}
