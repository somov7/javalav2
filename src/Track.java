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

    public Album getAlbum(){
        return this.album;
    }

    public Artist getArtist(){
        return this.album.getArtist();
    }

    public Genre getGenre() {
        return this.album.getGenre();
    }

}