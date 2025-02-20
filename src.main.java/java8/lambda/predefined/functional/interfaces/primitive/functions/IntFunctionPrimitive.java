package java8.lambda.predefined.functional.interfaces.primitive.functions;

import java.util.function.*;

public class IntFunctionPrimitive {
    public static void main(String[] args) {
        IntFunction<Integer> fun1 = i -> i + i;
        ToIntFunction<String> fun2 = s -> s.length();
        ToIntBiFunction<String, String> fun3 = (s1, s2) -> (s1 + s2).length();

        LongFunction<Long> fun4 = l -> l + Integer.MAX_VALUE;
        ToLongFunction<Long> fun5 = l -> Long.MAX_VALUE - l;
        ToLongBiFunction<Long, Long> fun6 = (l1, l2) -> l1 + l2;

        int[] intArray = {-10, -5, 0, 5, 10, 15, 20, 25, 30, 35, 40};
        long[] longArray = {-10L, -5L, 0L, 5L, 10L, 15L, 20L, 25L, 30L, 35L, 40L};
        String[] stringArray = {"Arif", "Shabbir", "Raju", "Raza", "Wahid", "Asif", "Shabab"};

        for (int x : intArray) {
            // using fun1, the AutoBoxing (Primitive int to Wrapper Integer) is happening
            System.out.println(fun1.apply(x));
        }

        for (String name : stringArray) {
            // applyAsInt will maintain the primitive in return type
            System.out.println(fun2.applyAsInt(name));
            System.out.println(fun3.applyAsInt(name, " Alam"));
        }

        for (long l : longArray) {
            // using fun1, the AutoBoxing (Primitive int to Wrapper Integer) is happening
            System.out.println(fun4.apply(l));
            System.out.println(fun5.applyAsLong(l));
            System.out.println(fun6.applyAsLong(l, l));
        }

    }
}
