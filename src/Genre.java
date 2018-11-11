public class Genre {

    String name;
    Genre parent;

    public Genre(Genre other){
        this.name = other.name;
        this.parent = other.parent;
    }

    public Genre(String name){
        this.name = name;
        this.parent = null;
    }

    public Genre(String name, Genre parent){
        this.name = name;
        this.parent = parent;
    }

    public String toString(){
        return this.name;
    }

    public String fullName() {
        if(parent == null)
            return this.name;
        return parent.toString() + " : " + this.name;
    }

}
