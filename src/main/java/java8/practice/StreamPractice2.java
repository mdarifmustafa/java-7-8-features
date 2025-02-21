package java8.practice;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamPractice2 {

    public static void main(String[] args) {
//        Exercise 1: Filtering and Collecting
        List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> oddNumbers = numbers1.stream().filter(i -> i % 2 != 0).collect(Collectors.toList());

//        Exercise 2: Mapping and Reducing
        List<String> words1 = Arrays.asList("apple", "banana", "cherry", "date");
        int totalLength = words1.stream().map(String::length).mapToInt(Integer::intValue).sum();

//        Exercise 3: Finding Maximum and Minimum
        List<Integer> numbers2 = Arrays.asList(10, 4, 8, 1, 3, 9, 7);
        List<Integer> sortedNumbers = numbers2.stream().sorted(Integer::compareTo).collect(Collectors.toList());

//        int max = numbers2.stream().max(Integer::compare).orElseThrow();
//        int min = numbers2.stream().min(Integer::compare).orElseThrow();

//        Exercise 4: Grouping
        List<String> words2 = Arrays.asList("apple", "banana", "cherry", "date", "fig", "grape");
        Map<Integer, List<String>> wordsPerLength = words2.stream()
            .collect(Collectors.groupingBy(String::length, Collectors.mapping(String::valueOf, Collectors.toList())));

//        Exercise 5: Joining
        List<String> words3 = Arrays.asList("apple", "banana", "cherry", "date");
        String joinedWords = words3.stream().collect(Collectors.joining(", "));


        System.out.println("Odd numbers: " + oddNumbers);
        System.out.println("Total Length: " + totalLength);

        System.out.println("Maximum: " + sortedNumbers.get(sortedNumbers.size() - 1));
        System.out.println("Minimum: " + sortedNumbers.get(0));

        System.out.println("Words Grouped by Length: " + wordsPerLength);

        System.out.println("Joined String: " + joinedWords);
    }

}
