package java8.lambda.predefined.functional.interfaces.function;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;

public class Basic {
    public static void main(String[] args) {
        Function<String, Integer> getLengthFun = s -> s.length();
        Function<String, String> removeSpaces = s -> s.replaceAll("\\s", "");
        Function<Integer, Boolean> notGreaterThanHundred = I -> I > 100;
        Function<String, Boolean> isFiveLettersOrLonger = I -> I.length() >= 5;
        Function<Collection, Boolean> isCollectionEmpty = I -> I.isEmpty();
        Function<Integer, Integer> square = i -> i * i;
        Function<String, Integer> countSpaces = s -> s.length() - removeSpaces.apply(s).length();

        List<String> list = new ArrayList<>();
        list.add("Hello");

        System.out.println("Length of \"Hello Brother\" is: " + getLengthFun.apply("Hello Brother"));
        System.out.println("Remove whitespaces of \"Hello Brother\" is: " + removeSpaces.apply("Hello Brother"));
        System.out.println("100 is: " + notGreaterThanHundred.apply(100));
        System.out.println("200 is: " + notGreaterThanHundred.apply(200));
        System.out.println("50 is: " + notGreaterThanHundred.apply(50));

        System.out.println("abcdefghijklmnopqrstuvwxyz is: " + isFiveLettersOrLonger.apply("abcdefghijklmnopqrstuvwxyz"));
        System.out.println("null is: " + isFiveLettersOrLonger.apply("null"));

        System.out.println("list is empty: " + isCollectionEmpty.apply(list));

        System.out.println("Square of 10 is " + square.apply(10));

        System.out.println("Count whitespaces of \"Hello Brother\" is: " + countSpaces.apply("Hello Brother"));
    }
}
