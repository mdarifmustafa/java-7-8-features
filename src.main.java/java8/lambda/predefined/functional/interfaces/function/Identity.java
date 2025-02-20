package java8.lambda.predefined.functional.interfaces.function;

import java.util.function.Function;

public class Identity {

    public static void main(String[] args) {
        Function<String, String> f1 = Function.identity();
        // Returns a function that always returns its input argument.

        String s = f1.apply("Erum");

        System.out.println("Function Identity is: " + s);
    }
}
