package java8.lambda.predefined.functional.interfaces.primitive.predicate;

import java.util.function.DoublePredicate;

public class FloatingPredicatePrimitive {
    public static void main(String[] args) {
        DoublePredicate predicate1 = i -> i % 2f == 0;

        double[] doubleArray = {-10.5f, -5.0f, 0.0f, 5.0f, 10.0f, 15.0f, 20.67f, 25.32f, 30.87f, 35.10f, 40.0f};

        for (double x : doubleArray) {
            if (predicate1.test(x)) System.out.println(x);
        }

    }
}
