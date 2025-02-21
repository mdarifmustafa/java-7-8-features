package java8.lambda.predefined.functional.interfaces.biconsumer;

import java.util.function.BiConsumer;

public class Basic {
    public static void main(String[] args) {

        // BiConsumer interface accept took two arguments but not return anything.
        BiConsumer<String, String> getLengthFun = (s1, s2) -> System.out.printf(s1 + s2);

        getLengthFun.accept("Hello ", "Brother");
    }
}
