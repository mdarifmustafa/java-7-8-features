package java8.lambda.predefined.functional.interfaces.predicate;

import java.util.function.Predicate;

public class CharStartsWith {

    public static void main(String[] args) {
        String[] names = {"Sunny", "Kajol", "Mallika", "Katrina", "Kareena"};

        Predicate<String> startsWithK = name -> name.toLowerCase().charAt(0) == 'k';

        for (String name : names) if (startsWithK.test(name)) System.out.println(name);
    }
}
