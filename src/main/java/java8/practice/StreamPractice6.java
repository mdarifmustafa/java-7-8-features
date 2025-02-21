package java8.practice;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamPractice6 {

    public static void main(String[] args) {

//        Exercise 1: Filtering, Mapping, and Collecting
        List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> numbersDivisibleBy3 = numbers1.stream().filter(i -> i % 3 == 0).map(i -> i * i).collect(Collectors.toList());

//        Exercise 2: Flat Mapping and Collecting
        List<String> sentences1 = Arrays.asList("hello world", "world of java", "java streams");
        // approach 1 using Set
//        Set<String> uniqueWords  = sentences1.stream()
//                .flatMap(s -> Arrays.stream(s.split(" ")))
//                .collect(Collectors.toSet());

        // approach 2 using Java stream
        List<String> uniqueWords = sentences1.stream()
            .flatMap(s -> Arrays.stream(s.split(" ")))
            .distinct().collect(Collectors.toList());

//        Exercise 3: Grouping and Summing
        List<Integer> numbers2 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Map<Boolean, Integer> evenness = numbers2.stream()
            .collect(Collectors.groupingBy(i -> i % 2 == 0, Collectors.summingInt(Integer::intValue)));

//        Exercise 4: Partitioning and Collecting
        List<String> words1 = Arrays.asList("apple", "banana", "pear", "grape", "kiwi", "plum");
        Map<Boolean, List<String>> partitionedWords = words1.stream()
            .collect(Collectors.groupingBy(s -> s.length() > 4, Collectors.mapping(String::valueOf, Collectors.toList())));

//        Exercise 5: Collecting and Summarizing
        List<Integer> numbers3 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        IntSummaryStatistics statistics = numbers3.stream().mapToInt(Integer::intValue)
            .summaryStatistics();


        System.out.println("Squared Numbers Divisible by 3: " + numbersDivisibleBy3);
        System.out.println("Unique Words: " + uniqueWords);
        System.out.println("Sums by Evenness: " + evenness);
        System.out.println("Words Partitioned by Length: " + partitionedWords);
        System.out.println("Summary Statistics: " + statistics);
    }

}
