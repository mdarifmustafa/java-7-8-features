package java8.lambda.predefined.functional.interfaces.primitive.predicate;

import java.util.function.IntPredicate;
import java.util.function.LongPredicate;

public class IntPredicatePrimitive {
    public static void main(String[] args) {
        IntPredicate predicate1 = i -> i % 2 == 0;
        LongPredicate predicate2 = i -> i % 2 == 0;

        int[] intArray = {-10, -5, 0, 5, 10, 15, 20, 25, 30, 35, 40};
        long[] longArray = {-10L, -5L, 0L, 5L, 10L, 15L, 20L, 25L, 30L, 35L, 40L};

        for (int x : intArray) {
            if (predicate1.test(x)) System.out.println(x);
        }

        for (long x : longArray) {
            if (predicate2.test(x)) System.out.println(x);
        }

    }
}
