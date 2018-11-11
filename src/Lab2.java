import java.util.List;
import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public class Lab2{

    static Library lib = new Library();

    static void readInput(String fileName){

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            Scanner scanner;
            int cnt;

            /* Read artists */

            line = reader.readLine();
            scanner = new Scanner(line);
            cnt = scanner.nextInt();
            for(int i = 0; i < cnt; i++){
                line = reader.readLine();
                lib.addArtist(line);
            }

            /* Read genres */

            line = reader.readLine();
            scanner = new Scanner(line);
            cnt = scanner.nextInt();
            ArrayList<Genre> genres = new ArrayList<>();
            for(int i = 0; i < cnt; i++){
                line = reader.readLine();
                String genreName;
                Genre genre;
                int level = line.indexOf(genreName = line.trim());
                if(level == 0)
                    genre = lib.addGenre(genreName);
                else
                    genre = lib.addGenre(genreName, genres.get(level - 1));

                while(genres.size() < level)
                    genres.add(null);
                if(genres.size() == level)
                    genres.add(genre);
                else
                    genres.set(level, genre);
            }

            /* Read albums and tracks */

            line = reader.readLine();
            scanner = new Scanner(line);
            cnt = scanner.nextInt();

            for(int i = 0; i < cnt; i++) {
                String albumName = reader.readLine();
                String artistName = reader.readLine();
                String genreName = reader.readLine();
                int year = Integer.parseInt(reader.readLine());

                Album album = lib.addAlbum(albumName, lib.findArtistExact(artistName), lib.findGenreExact(genreName), year);

                int trackCount = Integer.parseInt(reader.readLine());
                for(int j = 0; j < trackCount; j++) {
                    line = reader.readLine();
                    lib.addTrack(line, album);
                }
            }

            /* Read compilations */

            line = reader.readLine();
            scanner = new Scanner(line);
            cnt = scanner.nextInt();

            for(int i = 0; i < cnt; i++) {
                String compilationName = reader.readLine();
                String genreName = reader.readLine();
                int year = Integer.parseInt(reader.readLine());

                Compilation compilation = lib.addCompilation(compilationName, lib.findGenreExact(genreName), year);

                int trackCount = Integer.parseInt(reader.readLine());
                System.out.println(trackCount);
                for(int j = 0; j < trackCount; j++) {
                    String songName = reader.readLine();
                    String artistName = reader.readLine();
                    lib.addTrackToCompilation(lib.findTrackExact(songName, artistName), compilation);
                }
            }

            reader.close();
        }
        catch (IOException e){
            return;
        }
    }

    public static void main(String args []){

        readInput("input.txt");

        ArrayList<Album> example1 = lib.findAlbum("Minutes", null, null,-1, Library.FIND_ALBUM);
        for(Album i : example1)
            System.out.println(i.toString() + ": album by " + i.getArtist().toString());
        System.out.println();

        ArrayList<Album> example2 = lib.findAlbum(null, null, "Rock", 2005,Library.FIND_ALBUM | Library.FIND_COMPILATION);
        for(Album i : example2) {
            if(i instanceof Compilation)
                System.out.println(i.toString() + ": compilation");
            else
                System.out.println(i.toString() + ": album by " + i.getArtist().toString());
        }
        System.out.println();

        ArrayList<Track> example3 = lib.findTrack("You", null, "Alternative");
        for(Track i : example3)
            System.out.println(i.toString() + ": song by " + i.getArtist().toString());
    }

}
