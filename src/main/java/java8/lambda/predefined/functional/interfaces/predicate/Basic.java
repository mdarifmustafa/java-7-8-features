package java8.lambda.predefined.functional.interfaces.predicate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

public class Basic {
    public static void main(String[] args) {
        Predicate<Integer> notGreaterThanHundred = I -> I > 100;
        Predicate<String> isFiveLettersOrLonger = I -> I.length() >= 5;
        Predicate<Collection> isCollectionEmpty = I -> I.isEmpty();

        List<String> list = new ArrayList<>();
        list.add("Hello");

        System.out.println("100 is: " + notGreaterThanHundred.test(100));
        System.out.println("200 is: " + notGreaterThanHundred.test(200));
        System.out.println("50 is: " + notGreaterThanHundred.test(50));

        System.out.println("abcdefghijklmnopqrstuvwxyz is: " + isFiveLettersOrLonger.test("abcdefghijklmnopqrstuvwxyz"));
        System.out.println("null is: " + isFiveLettersOrLonger.test("null"));

        System.out.println("list is empty: " + isCollectionEmpty.test(list));
    }
}
