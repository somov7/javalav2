public class Album {

    String name;
    Artist artist;
    Genre genre;
    int year;

    public Album(String name, Artist artist, Genre genre, int year) {
        this.name = name;
        this.artist = artist;
        this.genre = genre;
        this.year = year;
    }

    public String toString() {
        return this.name;
    }

    public String getArtist() {
        return artist.toString();
    }

}
