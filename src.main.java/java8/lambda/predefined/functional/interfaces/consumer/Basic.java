package java8.lambda.predefined.functional.interfaces.consumer;

import java.util.function.Consumer;

public class Basic {
    public static void main(String[] args) {

        // Consumer interface accept took an argument but not return anything.
        Consumer<String> getLengthFun = s -> System.out.printf("Length of \"%s\" is: %d", s, s.length());

        getLengthFun.accept("Hello Brother");
    }
}
