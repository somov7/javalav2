import java.util.List;
import java.util.ArrayList;

public class Compilation extends Album{

    List tracks = new ArrayList<Track>();

    public Compilation(String name, Genre genre, int year){
        super(name, null, genre, year);
    }

    public String toString() {
        return this.name;
    }


}
