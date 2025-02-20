package java8.lambda.predefined.functional.interfaces.bipredicate;

import java.util.function.BiPredicate;

public class Basic {
    public static void main(String[] args) {

        BiPredicate<String, String> getLengthFun = (s1, s2) -> (s1 + s2).length() > 10;

        System.out.println(getLengthFun.test("Hello ", "Brother"));
    }
}
