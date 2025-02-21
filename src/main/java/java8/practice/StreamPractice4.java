import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamPractice4 {

    public static void main(String[] args) {
//        Exercise 1: Filtering and Collecting
        List<Integer> numbers1 = Arrays.asList(5, 12, 9, 21, 3, 11, 7);
        long countNumberBiggerThanTen = numbers1.stream().filter(i -> i > 10).count();

//        Exercise 2: Mapping and Collecting
        List<String> words1 = Arrays.asList("hello", "world", "java", "streams");
        List<String> upperCaseWords = words1.stream().map(String::toUpperCase).collect(Collectors.toList());

//        Exercise 3: Summing with Conditions
        List<Integer> numbers2 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        long sumOfEvenNumbers = numbers2.stream().filter(i -> i % 2 == 0).mapToInt(Integer::intValue).sum();

//        Exercise 4: Grouping by First Character
        List<String> words2 = Arrays.asList("apple", "banana", "avocado", "blueberry", "cherry", "cranberry");
        Map<Character, List<String>> wordsAsPerCharacter = words2.stream()
                        .collect(Collectors.groupingBy(s -> s.charAt(0), Collectors.mapping(String::valueOf, Collectors.toList())));

//        Exercise 5: Finding Distinct Elements
        List<Integer> numbers3 = Arrays.asList(1, 2, 2, 3, 4, 4, 5, 5, 6);
        List<Integer> distinctNumbers = numbers3.stream().distinct().collect(Collectors.toList());

        System.out.println("Count of Numbers > 10: " + countNumberBiggerThanTen);
        System.out.println("Uppercase Words: " + upperCaseWords);
        System.out.println("Sum of Even Numbers: " + sumOfEvenNumbers);
        System.out.println("Words Grouped by First Character: " + wordsAsPerCharacter);
        System.out.println("Distinct Numbers: " + distinctNumbers);
    }

}
