package java8.lambda.predefined.functional.interfaces.predicate;

import java.util.function.Predicate;

public class Joining {

    public static void main(String[] args) {
        int[] x = {0, 5, 10, 15, 20, 25, 8, 30, 6, 35};

        Predicate<Integer> p1 = i -> i > 10;
        Predicate<Integer> p2 = i -> i % 2 == 0;

        System.out.println("The numbers greater than 10 are:");
        m1(p1, x);

        System.out.println("The even numbers are:");
        m1(p2, x);

        System.out.println("The numbers not greater than 10 are:");
        m1(p1.negate(), x);

        System.out.println("The numbers greater than 10 and Even numbers are:");
        m1(p1.and(p2), x);

        System.out.println("The numbers greater than 10 or Even numbers are:");
        m1(p1.or(p2), x);

    }

    private static void m1(Predicate<Integer> p, int[] x) {
        for (int x1 : x) if (p.test(x1)) System.out.println(x1);
    }
}
