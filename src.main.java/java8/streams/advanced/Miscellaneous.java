package java8.streams.advanced;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Miscellaneous {

    // Source of Education: https://www.youtube.com/watch?v=t1-YZ6bF-g0&t=353s

    public static void PrintHeader(final String str) {
        System.out.println(str);
        System.out.println(String.format("%0" + str.length() + "d", 0).replace("0", "-"));
    }

    public static void main(String[] args) throws IOException {
        // 1. Integer Streams
        PrintHeader("1. Integer Streams");
        IntStream.range(1, 10)
            .forEach(System.out::print);
        System.out.println("\n");

        // 2. Integer Streams with Skip
        PrintHeader("2. Integer Streams with Skip, will print after Skip excluding");
        IntStream.range(1, 10)
            .skip(5)
            .forEach(v -> System.out.print(v + " "));
        System.out.println("\n");

        // 3. Integer Streams with Sum
        PrintHeader("3. Integer Streams with Sum");
        System.out.print(IntStream.range(1, 10)
            .sum());
        System.out.println("\n");

        // 4. Stream of Sorted and findFirst
        PrintHeader("4. a) Stream of Sorted and findFirst");
        Stream.of("Ava", "Aneri", "Alberto")
            .sorted()
            .findFirst()
            .ifPresent(System.out::println);
        PrintHeader("4. b) Sorted and findLast");

        System.out.println(Stream.of("Ava", "Aneri", "Alberto")
            .sorted().reduce((first, second) -> second).get());
        System.out.println("\n");

        // 5. Stream from Array, sort, filter and print
        PrintHeader("5. Stream from Array, sort, filter and print");
        String[] names = {"Al", "Ankit", "Kushal", "Brent", "Sarika", "amanda", "Hans", "Shivika", "Sakeena", "Sarah"};
        Arrays.stream(names)
            .filter(x -> x.startsWith("S"))
            .sorted()
            .forEach(System.out::println);
        System.out.println();

        // 6. Average of Squares of an int array
        PrintHeader("6. Average of Squares of an int array");
        Arrays.stream(new int[]{2, 4, 6, 8, 10})
            .map(x -> x * x)
            .average()
            .ifPresent(System.out::println);
        System.out.println();

        // 7. Stream from List, filter and print
        PrintHeader("7. Stream from List, filter and print");
        List<String> people = Arrays.asList("Al", "Ankit", "Kushal", "Brent", "Sarika", "amanda", "Hans", "Shivika", "Sakeena", "Sarah");
        people.stream().map(String::toLowerCase)
            .filter(x -> x.startsWith("a"))
            .forEach(System.out::println);

        System.out.println();
    }
}
