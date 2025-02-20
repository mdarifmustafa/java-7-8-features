package java8.lambda.predefined.functional.interfaces.bifunction;

import java.util.function.BiFunction;

public class Basic {
    public static void main(String[] args) {

        BiFunction<String, String, Integer> lengthOfStrings = (s1, s2) -> (s1 + s2).length();

        System.out.println("Length of \"Hello Brother\" is: " + lengthOfStrings.apply("Hello ", "Brother"));
    }
}
