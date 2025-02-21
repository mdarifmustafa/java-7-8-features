package java8.practice;

import java.util.ArrayList;
import java.util.List;

public class StreamPractice8 {

    public static void main(String[] args) {

        List<String> names = new ArrayList<>();

        names.add("David");
        names.add("Johnson");
        names.add("Samontika");
        names.add("Brijesh");
        names.add("John");
        names.add("David");

        names.stream()//.peek(System.out::println)
            .filter(name -> name.length() > 5)
            .peek(e -> System.out.println("Filtered Name :" + e))
            .map(String::toUpperCase)
            .peek(e -> System.out.println("Mapped Name :" + e))
            .toArray();
    }

}
