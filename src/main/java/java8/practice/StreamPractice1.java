package java8.practice;

import java8.practice.models.Product;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class StreamPractice1 {
    private static List<Product> populate() {
        return Arrays.asList(
            new Product(1, "Laptop", 1000.00, "Electronics"),
            new Product(2, "Smartphone", 700.00, "Electronics"),
            new Product(3, "Tablet", 400.00, "Electronics"),
            new Product(4, "Book", 20.00, "Books"),
            new Product(5, "Notebook", 5.00, "Stationery")
        );
    }

    public static void main(String[] args) {
        List<Product> products = populate();

//        Filter: Find all products in the "Electronics" category.
        List<String> electronicsProduct = products.stream()
            .filter(p -> p.getCategory().equals("Electronics"))
            .map(Product::getName).collect(Collectors.toList());

//        Sort: Sort the products by price in ascending order.
        List<String> sortedByPrice = products.stream()
            .sorted((p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()))
            .map(p -> (p.getName() + " (" + p.getPrice() + ")"))
            .collect(Collectors.toList());

//        Map: Convert the list of products to a list of their names.
        List<String> productName = products.stream().map(Product::getName).collect(Collectors.toList());

//        Reduce: Calculate the total price of all products.
//        double totalPrice = products.stream().mapToDouble(p -> p.getPrice()).sum();
        double totalPrice = products.stream().map(Product::getPrice).reduce(0d, Double::sum);

//        Group: Group the products by their category.
        Map<String, List<String>> productPerCategory = products.stream()
            .collect(Collectors.groupingBy(Product::getCategory, Collectors.mapping(Product::getName, Collectors.toList())));

        System.out.println(electronicsProduct);

        System.out.println(sortedByPrice);

        System.out.println(productName);

        System.out.println(totalPrice);

        System.out.println(productPerCategory);
    }
}