package java8.practice;

import java8.practice.models.Person;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamPractice5 {

    public static void main(String[] args) {

//        Question 1: Filtering and Collecting
        List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> oddNumbers = numbers1.stream().filter(i -> i % 2 != 0).collect(Collectors.toList());

//        Question 2: Mapping and Collecting
        List<String> strings1 = Arrays.asList("hello", "world", "java", "streams");
        List<String> upperCaseStrings = strings1.stream().map(String::toUpperCase).collect(Collectors.toList());

//        Question 3: Reducing
        List<Integer> numbers2 = Arrays.asList(1, 2, 3, 4, 5);
        int sumOfNumbers = numbers2.stream().mapToInt(Integer::intValue).sum();

//        Question 4: Filtering, Mapping, and Collecting
        List<String> strings2 = Arrays.asList("hi", "hello", "apple", "bat");
        List<String> upperCaseWordsMoreThanLength4 = strings2.stream().filter(s -> s.length() > 4).map(String::toUpperCase).collect(Collectors.toList());

//        Question 5: Creating a Stream of Custom Objects
        List<Person> people = Arrays.asList(
            new Person("John", 25),
            new Person("Jane", 17),
            new Person("Tom", 20),
            new Person("Lucy", 16)
        );
        List<String> adultPeople = people.stream().filter(p -> p.getAge() >= 18).map(Person::getFirstName).collect(Collectors.toList());

        System.out.println("Odd numbers: " + oddNumbers);
        System.out.println("Uppercase strings: " + upperCaseStrings);
        System.out.println("Sum of numbers: " + sumOfNumbers);
        System.out.println("Filtered and mapped strings: " + upperCaseWordsMoreThanLength4);
        System.out.println("Names of adults: " + adultPeople);
    }

}
