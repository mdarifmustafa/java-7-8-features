package java8.streams.intermediate;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamIterator {

    public static void main(String[] args) {

//        Infinite time it will run
//        Stream.iterate(1, x -> x + 1).forEach(System.out::println);

//        So to avoid infinite use limit function
        Stream.iterate(1, x -> x + 1).limit(5).forEach(System.out::println);

        /*
            Syntax: Stream.iterate(T t, UnaryOperator f)
            UnaryOperator, where input and output are same type.

            Here, whatever it returns, it updates the same initialValue.

            Explanation,
            Stream.iterate(initialValue, initialValue -> initialValue + 1)
            Stream.iterate(1, x -> x + 1) // x is now two
            Stream.iterate(1, x -> x + 1) // x is now three
            Stream.iterate(1, x -> x + 1) // x is now four

            Recommended: always to use with Stream.iterate -
            limit: function runs the iterator for that much count, hence it can run for finite count.
        * */

        System.out.println("\n\nLet's run a table 1 to 10 in one line -");

        // Let's run a table 1 to 10
        Stream.iterate(1, x -> ++x).limit(10)
            .flatMap(x -> Stream.of(
                    Stream.iterate(x, y -> y + x).limit(10)
                        .map(I -> String.valueOf(I).concat("\t"))
                        .collect(Collectors.joining())
                )
            )
            .forEach(System.out::println);


        // Will give 5 lines blank space
        Stream.iterate(1, x -> x + 1).map(x -> " ").limit(5).forEach(System.out::println);


    }
}
