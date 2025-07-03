package java8.practice;

import java8.practice.models.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamPractice9 {

    public static void populateFruits(List<List<String>> fruits) {
        fruits.addAll(Arrays.asList(
            Arrays.asList("Apple", "Banana", "Cherry", "Grapes", "Pineapple"),
            Arrays.asList("Mango", "Peach", "Plum", "Apricot", "Orange"),
            Arrays.asList("Watermelon", "Kiwi", "Papaya", "Lychee", "Strawberry"),
            Arrays.asList("Blueberry", "Raspberry", "Blackberry", "Coconut", "Guava"),
            Arrays.asList("Pomegranate", "Fig", "Date", "Dragonfruit", "Cantaloupe"),
            Arrays.asList("Tangerine", "Nectarine", "Passionfruit", "Starfruit", "Mulberry"),
            Arrays.asList("Jackfruit", "Persimmon", "Cranberry", "Gooseberry", "Durian"),
            Arrays.asList("Rambutan", "Longan", "Soursop", "Jujube", "Tamarind"),
            Arrays.asList("Avocado", "Clementine", "Boysenberry", "Currant", "Sapodilla"),
            Arrays.asList("Breadfruit", "Ugli fruit", "Salak", "Quince", "Medlar")
        ));
    }

    public static void populateEmployees(List<Employee> list) {
        list.addAll(Arrays.asList(
            new Employee("Alice", 30, "HR"),
            new Employee("Bob", 25, "Finance"),
            new Employee("Charlie", 35, "Sales"),
            new Employee("David", 28, "Sales"),
            new Employee("Eva", 31, "Marketing"),
            new Employee("Frank", 29, "Operations"),
            new Employee("Grace", 33, "HR"),
            new Employee("Henry", 27, "Marketing"),
            new Employee("Isla", 26, "Support"),
            new Employee("Jack", 32, "Business"),
            new Employee("Karen", 34, "Marketing"),
            new Employee("Liam", 24, "Engineering"),
            new Employee("Mia", 30, "Finance"),
            new Employee("Noah", 36, "Marketing"),
            new Employee("Olivia", 23, "Operations"),
            new Employee("Peter", 37, "Security"),
            new Employee("Quinn", 22, "Operations"),
            new Employee("Rose", 38, "Sales"),
            new Employee("Sam", 39, "Business"),
            new Employee("Tina", 40, "Operations")
        ));
    }

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve");
        // filter names length greater than 3
        names.stream().filter(name -> name.length() > 3).forEach(System.out::println);


        List<Employee> employees = new ArrayList<>();
        populateEmployees(employees);
        // filter employees with age greater than 30
        employees.stream().filter(employee -> employee.getAge() > 30).forEach(System.out::println);
        employees.stream().map(employee -> employee.getName()).forEach(System.out::println);


        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        // multiply each number by 2 using map
        numbers.stream().filter(number -> number != 0).map(number -> number * 2)
            .forEach(System.out::println);

        List<List<String>> fruits = new ArrayList<>();
        populateFruits(fruits);

        // Flatten the list of fruits and print each fruit
        fruits.stream().flatMap(List::stream).forEach(System.out::println);

        List<Integer> numbers1 = Arrays.asList(1, 3, 4, 6, 5, 2);
        numbers1.stream().sorted().forEach(System.out::println);

        employees.stream().map(employee -> employee.getName())
            .sorted(String::compareTo)
            .forEach(System.out::println);

    }
}
