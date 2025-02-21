package java8.lambda.predefined.functional.interfaces.supplier;

import java.util.Date;
import java.util.function.Supplier;

public class Basic {
    public static void main(String[] args) {

        // Supplier interface took no argument but return the processed object, and also you have to mention the return type generics.
        Supplier<Date> supplierDate = () -> new Date();

        System.out.println("Current System date is: " + supplierDate.get());
    }
}
