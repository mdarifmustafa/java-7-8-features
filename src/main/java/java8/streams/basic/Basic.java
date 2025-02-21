package java8.streams.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Basic {

    public static void populateIntegers(List<Integer> list) {
        list.add(0);
        list.add(10);
        list.add(20);
        list.add(5);
        list.add(15);
        list.add(25);
    }

    public static void populateStrings(List<String> list) {
        list.add("Pavan");
        list.add("RaviTeja");
        list.add("Chiranjeevi");
        list.add("Venkatesh");
        list.add("Nagarjuna");
        list.add("PrakashRaj");
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        populateIntegers(list);

        List<Integer> filteredList = list.stream().filter(I -> I % 2 == 0).collect(Collectors.toList());
        List<Integer> mappedList = list.stream().map(I -> I * 2).collect(Collectors.toList());

        Stream mapStream = list.stream().filter(I -> I / 3 > 5);

        System.out.println("filteredList: " + filteredList);
        System.out.println("mappedList: " + mappedList);

        mapStream.forEach(I -> System.out.println(I));

        List<String> actors = new ArrayList<>();
        populateStrings(actors);

        Predicate<String> filterNameLength = s -> s.length() >= 9;
        Function<String, String> separateCaps = s -> {
            String result = "";
            char[] letters = s.toCharArray();
            for (char c : letters) {
                if (Character.isUpperCase(c)) {
                    result += " ";
                }
                result += c;
            }
            return result;
        };

//        Filtering in normal stream way
//        List<String> bigNamesActor = actors.stream().filter(s -> s.length() >= 9).collect(Collectors.toList());

//        Filtering using Predicate object reference
        List<String> bigNamesActor = actors.stream().filter(filterNameLength::test).collect(Collectors.toList());
        System.out.println(bigNamesActor);

//        Separating name and putting space in between, wherever it is letter caps.
        bigNamesActor = bigNamesActor.stream().map(separateCaps::apply).collect(Collectors.toList());
        System.out.println(bigNamesActor);

//        let's do this all above things in one line
        List<String> oneLineResult = actors.stream().filter(s -> s.length() >= 9).map(s -> {
            String result = "";
            char[] letters = s.toCharArray();
            for (char c : letters) {
                if (Character.isUpperCase(c)) {
                    result += " ";
                }
                result += c;
            }
            return result;
        }).map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(oneLineResult);

        // total count of objects, count is a method based on stream, which returns Long type
        long count = actors.stream().filter(s -> s.length() >= 9).count();

        System.out.println("count is: " + count);

        // Sort numbers using default sorted (by default only does ascending order) and Comparator sorted in descending order
        List<Integer> defaultSortedNumbers = list.stream().sorted().collect(Collectors.toList());
        System.out.println("defaultSortedNumbers: " + defaultSortedNumbers);

        List<Integer> descSortedNumbers = list.stream().sorted((i1, i2) -> -i1.compareTo(i2)).collect(Collectors.toList());
        System.out.println("descSortedNumbers: " + descSortedNumbers);

        List<Integer> manuallySortedNumbers = list.stream().sorted((i1, i2) -> i2.compareTo(i1)).collect(Collectors.toList());
        System.out.println("manuallySortedNumbers: " + manuallySortedNumbers);

        // Finding Min and Max
        Integer min = list.stream().min((i1, i2) -> i1.compareTo(i2)).get();
        System.out.println("Min value in list: " + min);

        Integer max = list.stream().max((i1, i2) -> i1.compareTo(i2)).get();
        System.out.println("Max value in list: " + max);

        // ForEach , print every name in array list
//        actors.stream().forEach(System.out::print);
        actors.stream().forEach(s -> System.out.print("Actor: " + s + ", "));

//        Converting ArrayList to toArray using Constructor reference
        Integer[] numbersArray = list.stream().toArray(Integer[]::new);
        for (Integer number : numbersArray) {
            System.out.println(number);
        }

//        Stream.of() method we can apply for group of object, values and for arrays
        Stream.of(numbersArray).forEach(System.out::println); // applied over arrayObject

        Stream<Integer> numberStream = Stream.of(9, 99, 999, 9999, 99999, 999999); // group of values
        numberStream.forEach(System.out::println);

        Stream.of(10.0f, 10.1f, 10.2f, 10.3f, 10.4f).forEach(System.out::println);

    }
}
