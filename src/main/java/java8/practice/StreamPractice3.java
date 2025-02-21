import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamPractice3 {

    public static void main(String[] args) {
//        Exercise 1: Filtering and Collecting
        List<Integer> numbers1 = Arrays.asList(1, 3, 5, 7, 9, 2, 4, 6, 8, 10);
        List<Integer> numbersBiggerThanFive = numbers1.stream().filter(i -> i >= 5).collect(Collectors.toList());

//        Exercise 2: Mapping and Summing
        List<String> words1 = Arrays.asList("java", "streams", "are", "cool");
        double avgOfLength = words1.stream().mapToInt(String::length).average().orElse(0);

//        Exercise 3: Finding Second Largest
        List<Integer> numbers2 = Arrays.asList(12, 34, 56, 78, 90, 21, 45);
        int secondLargest = numbers2.stream().sorted().skip(numbers2.size() - 2).min(Integer::compareTo).orElse(0);
//        int secondLargest = numbers2.stream()
//                .sorted(Comparator.reverseOrder())
//                .distinct()
//                .skip(1)
//                .findFirst()
//                .orElse(0);

//        Exercise 4: Partitioning vowels
        List<String> words2 = Arrays.asList("apple", "banana", "orange", "grape", "kiwi");
        Map<Boolean, List<String>> booleanAsPerVowels = words2.stream()
                .collect(Collectors.groupingBy(s -> "aeiou".indexOf(s.charAt(0)) > -1, Collectors.mapping(String::valueOf, Collectors.toList())));

//        Exercise 5: Joining with Prefix and Suffix
        List<String> words3 = Arrays.asList("one", "two", "three");
        String joinedSentence = words3.stream().collect(Collectors.joining(", ", "[", "]"));


        System.out.println("Numbers >= 5: " + numbersBiggerThanFive);
        System.out.println("Average Length: " + avgOfLength);
        System.out.println("Second Largest: " + secondLargest);
        System.out.println("Words Partitioned by Starting Letter: " + booleanAsPerVowels);
        System.out.println("Joined String: " + joinedSentence);
    }

}
