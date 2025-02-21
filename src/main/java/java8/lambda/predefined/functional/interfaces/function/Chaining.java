package java8.lambda.predefined.functional.interfaces.function;

import java.util.function.Function;

public class Chaining {

    public static void main(String[] args) {

        Function<String, String> toUpperCase = v -> v.toUpperCase();
        Function<String, String> first9Chars = v -> v.substring(0, 8);

        // toUpperCase will run first before first9Chars
        System.out.println(toUpperCase.andThen(first9Chars).apply("MohammadRazaAlam"));

        // Opposite of andThen, first9Chars will run first before toUpperCase
        System.out.println(toUpperCase.compose(first9Chars).apply("MohammadRazaAlam"));


        Function<Integer, Integer> f1 = i -> i + i;
        Function<Integer, Integer> f2 = i -> i * i * i;

        // toUpperCase will run first before first9Chars
        System.out.println(f1.andThen(f2).apply(2));

        // Opposite of andThen, first9Chars will run first before toUpperCase
        System.out.println(f1.compose(f2).apply(2));

    }
}
