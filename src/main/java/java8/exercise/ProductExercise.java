package java8.exercise;

import java8.models.Product;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ProductExercise {

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

        List<Product> electronicsProduct = products.stream().filter(p -> p.getCategory().equals("Electronics")).collect(Collectors.toList());

        System.out.println(electronicsProduct);
    }


}
