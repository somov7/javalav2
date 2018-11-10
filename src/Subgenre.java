public class Subgenre extends Genre {

    String subname;

    public Subgenre(Genre genre, String name) {
        super(genre);
        this.subname = name;
    }

    public String toString() {
        return this.subname;
    }

}
