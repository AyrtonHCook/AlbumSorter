public class Duration implements Comparable<Duration> {
    private int hours;
    private int minutes;
    private int seconds;

    public Duration(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
        normalise();
    }
    public int toSeconds(){
        return(hours * 3600 + minutes * 60 + seconds);
    }

    public Duration add(Duration other){
        return new Duration(hours + other.hours, minutes + other.minutes, seconds + other.seconds);
    }
    private void normalise() {
        this.minutes += this.seconds / 60;
        this.seconds = this.seconds % 60;
        this.hours += this.minutes / 60;
        this.minutes = this.minutes % 60;
    }

    public int compareTo(Duration other) {
        return (Integer.compare(this.toSeconds(), other.toSeconds()));
    }

    public String toString() {
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }


}