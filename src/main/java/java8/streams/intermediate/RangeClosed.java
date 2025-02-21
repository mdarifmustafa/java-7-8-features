package java8.streams.intermediate;

import java.util.stream.IntStream;

public class RangeClosed {
    public static void main(String[] args) {
        System.out.println("\n\nLet's run a table 1 to 10 in one line -");

        IntStream.rangeClosed(1, 10)
            .forEach(I -> IntStream.iterate(I, y -> y + I).limit(10)
                .forEach(J -> System.out.print(J + ((I * 10) == J ? "\n" : "\t"))));
    }
}
