import java.util.List;
import java.util.ArrayList;

public class Library {

    public static final int LIB_ARTIST = 1,
        LIB_ALBUM = 2,
        LIB_TRACK = 4,
        LIB_GENRE = 8;

    List artists = new ArrayList<Artist>(),
        albums = new ArrayList<Compilation>(),
        tracks = new ArrayList<Track>(),
        genres = new ArrayList<Genre>();

    class Search {
        int where,
            year;
        String artistName,
            albumName,
            genreName,
            trackName;

        Search(int where, int year, String artistName, String albumName, String genreName, String trackName){
            this.where = where;
            this.year = year;
            this.artistName = artistName;
            this.albumName = albumName;
            this.genreName = genreName;
            this.trackName = trackName;
        }

        void find() {

        }

    }

    Search search;

}
