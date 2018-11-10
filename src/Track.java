public class Track {
    String name;
    Album album;

    public Track (String name, Album album){
        this.name = name;
        this.album = album;
    }

    public String toString() {
        return this.name;
    }

}