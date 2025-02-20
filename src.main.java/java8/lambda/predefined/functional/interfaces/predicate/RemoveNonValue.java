package java8.lambda.predefined.functional.interfaces.predicate;

import java.util.function.Predicate;

public class RemoveNonValue {

    public static void main(String[] args) {
        String[] names = {"Durga", " ", null, "Ravi", "   ", "Sheena", null, "Aafreen"};

        Predicate<String> notNull = value -> value != null;
        Predicate<String> nonEmpty = value -> value.trim().length() > 0;

        for (String name : names) if (notNull.and(nonEmpty).test(name)) System.out.println(name);
    }

}
