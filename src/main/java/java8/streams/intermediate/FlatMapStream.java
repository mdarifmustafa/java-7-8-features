package java8.streams.intermediate;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class FlatMapStream {

    private static void printStream(Stream<?> stream) {
        stream.forEach(System.out::println);
    }

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            list.add(i);

        List<Double> doubleList = list.stream()
            .flatMapToDouble(I -> I % 2 == 0 ? DoubleStream.empty() : DoubleStream.of(I, I * 10))
            .boxed()
            .collect(Collectors.toList());

        doubleList.stream().forEach(System.out::println);

        // 1. Flatten a list of lists into a single list
        List<List<String>> listOLists = Arrays.asList(Arrays.asList("a", "b"), Arrays.asList("c"));
        List<String> flat = listOLists.stream().flatMap(List::stream).collect(Collectors.toList());
        printStream(flat.stream());

// 2. Split sentences into words
        List<String> sentences = Arrays.asList("hello world", "java stream");
        List<String> words = sentences.stream().flatMap(s -> Arrays.stream(s.split(" "))).collect(Collectors.toList());
        printStream(words.stream());

// 3. Convert list of comma-separated strings to individual elements
        List<String> data = Arrays.asList("a,b", "c,d");
        List<String> items = data.stream().flatMap(s -> Arrays.stream(s.split(","))).collect(Collectors.toList());
        printStream(items.stream());

// 4. Extract chars from list of strings
        List<String> strings = Arrays.asList("ab", "cd");
        List<Character> chars = strings.stream().flatMap(s -> s.chars().mapToObj(c -> (char) c)).collect(Collectors.toList());
        printStream(chars.stream());

// 5. Flatten list of Optionals
        List<Optional<String>> optionals = Arrays.asList(Optional.of("a"), Optional.empty(), Optional.of("b"));
        List<String> present = optionals.stream().flatMap(o -> o.map(Stream::of).orElseGet(Stream::empty)).collect(Collectors.toList());
        printStream(present.stream());

// 6. Flatten array of int arrays
        int[][] array = {{1, 2}, {3, 4}};
        int[] flatArray = Arrays.stream(array).flatMapToInt(Arrays::stream).toArray();
        printStream(Arrays.stream(flatArray).boxed());

// 7. Convert List<String> to Stream<Character>
        List<String> wordsList = Arrays.asList("hi", "bye");
        List<Character> charList = wordsList.stream().flatMap(w -> w.chars().mapToObj(c -> (char) c)).collect(Collectors.toList());
        printStream(charList.stream());

// 8. FlatMap with filtering nulls from nested list
        List<List<String>> nested = Arrays.asList(Arrays.asList("a", null), Arrays.asList("b"));
        List<String> nonNull = nested.stream().flatMap(List::stream).filter(Objects::nonNull).collect(Collectors.toList());
        printStream(nonNull.stream());

// 9. Flatten list of user hobbies
        class User {
            List<String> hobbies;

            User(List<String> h) {
                this.hobbies = h;
            }
        }
        List<User> users = Arrays.asList(new User(Arrays.asList("reading", "gaming")), new User(Arrays.asList("coding")));
        List<String> allHobbies = users.stream().flatMap(u -> u.hobbies.stream()).collect(Collectors.toList());
        printStream(allHobbies.stream());

// 10. Flatten Stream of Optional values
        Stream<Optional<String>> optionalStream = Stream.of(Optional.of("x"), Optional.empty(), Optional.of("y"));
        List<String> result = optionalStream.flatMap(o -> o.map(Stream::of).orElseGet(Stream::empty)).collect(Collectors.toList());
        printStream(result.stream());

    }
}
