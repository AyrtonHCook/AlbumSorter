public class Track {
    private String title;
    private Duration duration;

    public Track(String title, Duration duration){
        this.title = title;
        this.duration = duration;
    }
    public String getTitle() {
        return title;
    }
    public Duration getDuration() {
        return duration;
    }
    public String toString(){
        return duration + " - " + title;
    }
}
