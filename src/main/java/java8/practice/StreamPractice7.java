import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamPractice7 {

    public static void main(String[] args) {
                String data="Arif is a very innocent girl";

                Map<Character, Long>  values = data.chars().mapToObj(c -> (char) c)
                    .collect(Collectors.groupingBy(e -> e, Collectors.counting()))
                    .entrySet().stream().filter(entry -> entry.getValue() == 1)
                    .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));
                values.forEach((k,v) -> System.out.println(k +"--"+ v));
        System.out.println("===============================================");
             data.chars().mapToObj(c -> (char) c)
            .collect(Collectors.groupingBy(e -> e, Collectors.counting()))
            .entrySet().stream().filter(entry -> entry.getValue() == 1)
            .map(Map.Entry::getKey).forEach(System.out::println);

        System.out.println("===============================================");
            Stream<Character> chry= data.chars().mapToObj(c -> (char) c)
            .collect(Collectors.groupingBy(e -> e, Collectors.counting()))
            .entrySet().stream().filter(entry -> entry.getValue() == 1)
            .map(Map.Entry::getKey);
            chry.forEach(System.out::println);
    }

}
