package java8.lambda.predefined.functional.interfaces.consumer;

import java8.models.Movie;

import java.util.ArrayList;
import java.util.function.Consumer;

public class Chaining {

    private static void populate(ArrayList<Movie> list) {
        list.add(new Movie("Sultan", "Salman Khan", "Anushka"));
        list.add(new Movie("Jab We Met", "Shahid Kapoor", "Kareena"));
        list.add(new Movie("Tiger Zinda Hai", "Salman Khan", "Katrina"));
        list.add(new Movie("Wanted", "Salman Khan", "Ayesha"));
        list.add(new Movie("Jawan", "Shahrukh Khan", "Nainthara"));
        list.add(new Movie("Pathan", "Shahrukh Khan", "Deepika"));
        list.add(new Movie("Chennai Express", "Shahrukh Khan", "Deepika"));
    }

    public static void main(String[] args) {
        ArrayList<Movie> list = new ArrayList<>();

        populate(list);

        Consumer<Movie> notification = m -> System.out.println(m.name + " is ready to release!");
        Consumer<Movie> result = m -> System.out.println(m.name + " result is superhit!");
        Consumer<Movie> dbPersist = m -> System.out.println(m.name + " saved to database!\n---------------------------------");
        Consumer<Movie> chainedConsumer = m -> notification.andThen(result).andThen(dbPersist).accept(m);

        for (Movie movie : list) {
            chainedConsumer.accept(movie);
        }
    }
}
