package java8.models;

public class Movie {

    public String name;
    public String actor;

    public String actress;

    public Movie(String name, String actor, String actress) {
        this.name = name;
        this.actor = actor;
        this.actress = actress;
    }

    @Override
    public String toString() {
        return "Movie{" +
            "name='" + name + '\'' +
            ", actor='" + actor + '\'' +
            ", actress='" + actress + '\'' +
            '}';
    }
}
