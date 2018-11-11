import java.util.List;
import java.util.ArrayList;

public class Library {

    public static final int FIND_ALBUM = 1, FIND_COMPILATION = 2;

    ArrayList<Artist> artists = new ArrayList<>();
    ArrayList<Album> albums = new ArrayList<>();
    ArrayList<Track> tracks = new ArrayList<>();
    ArrayList<Genre> genres = new ArrayList<>();


    public Artist findArtistExact(String name){
        for(Artist artist : artists)
            if(artist.toString().equals(name))
                return artist;
        return null;
    }

    public ArrayList <Artist> findArtist(String name) {
        ArrayList<Artist> ret = new ArrayList<>();
        for(Artist artist : artists) {
            if(artist.toString().toLowerCase().contains(name.toLowerCase()))
                ret.add(artist);
        }
        return ret;
    }

    public Album findAlbumExact(String name, String artistName){
        for(Album album: albums)
            if(album.toString().equals(name) && album.getArtist().equals(artistName))
                return album;
        return null;
    }

    public ArrayList <Album> findAlbum(String name, String artistName, String genreName, int year, int where) {
        ArrayList<Album> ret = new ArrayList<>();
        for(Album album : albums) {
            if((name == null || album.toString().toLowerCase().contains(name.toLowerCase()))
                    && (artistName == null || album.getArtist().toString().toLowerCase().contains(artistName.toLowerCase()))
                    && (genreName == null || album.getGenre().fullName().toLowerCase().contains(genreName.toLowerCase()))
                    && (year < 0 || album.getYear() == year)
                    /*&& ((where & albumOrCompilation(album))) > 0*/)
            ret.add(album);
        }
        return ret;
    }

    public Track findTrackExact(String name, String artistName){
        for(Track track : tracks)
            if(track.toString().equals(name)
                && track.getArtist().toString().equals(artistName))
                return track;
        return null;
    }

    public ArrayList <Track> findTrack(String name, String artistName, String genreName) {
        ArrayList<Track> ret = new ArrayList<>();
        for(Track track : tracks) {
            if((name == null || track.toString().toLowerCase().contains(name.toLowerCase()))
                && (genreName == null || track.getGenre().fullName().toLowerCase().contains(genreName.toLowerCase()))
                && (artistName == null || track.getArtist().toString().toLowerCase().contains(artistName.toLowerCase())))
                ret.add(track);
        }
        return ret;
    }

    public Genre findGenreExact(String name){
        for(Genre genre : genres) {
            if (genre.toString().equals(name))
                return genre;
        }
        return null;
    }

    public ArrayList <Genre> findGenre(String name){
        ArrayList<Genre> ret = new ArrayList<>();
        for(Genre genre : genres) {
            if(genre.fullName().toLowerCase().contains(name.toLowerCase()))
                ret.add(genre);
        }
        return ret;
    }

    public Artist addArtist(String name) {
        if(findArtistExact(name) != null) {
            throw new RuntimeException(name + ": such artist already exists");
        }
        Artist artist = new Artist(name);
        artists.add(artist);
        return artist;
    }

    public Genre addGenre(String name){
        if(findGenreExact(name) != null) {
            throw new RuntimeException(name + ": such genre already exists");
        }
        Genre genre = new Genre(name);
        genres.add(genre);
        return genre;
    }

    public Genre addGenre(String name, Genre parent){
        if(findGenreExact(name) != null) {
            throw new RuntimeException(name + ": such genre already exists");
        }
        Genre genre = new Genre(name, parent);
        genres.add(genre);
        return genre;
    }

    public Album addAlbum(String name, Artist artist, Genre genre, int year){
        if(findAlbumExact(name, artist.toString()) != null) {
            throw new RuntimeException(name + ": such album already exists");
        }
        Album album = new Album(name, artist, genre, year);
        albums.add(album);
        return album;
    }

    public Compilation addCompilation(String name, Genre genre, int year){
        Compilation album = new Compilation(name, genre, year);
        albums.add(album);
        return album;
    }

    public Track addTrack (String name, Album album){
        if(findTrackExact(name, album.getArtist().toString()) != null) {
            throw new RuntimeException(name + ": such track already exists");
        }
        Track track = new Track(name, album);
        tracks.add(track);
        return track;
    }

    public void addTrackToCompilation(Track track, Compilation compilation){
        compilation.addTrack(track);
    }

    int albumOrCompilation(Album album) {
        if(album instanceof Compilation)
            return FIND_COMPILATION;
        else
            return FIND_ALBUM;
    }
}
