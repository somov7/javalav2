public class Subgenre extends Genre {

    String subname;

    public Subgenre(String name, Genre genre) {
        super(genre);
        this.subname = name;
    }

    public String toString() {
        return this.name + " : " + this.subname;
    }

}
