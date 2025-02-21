package java8.lambda.predefined.functional.interfaces.primitive.unaryoperator;

import java.util.function.IntUnaryOperator;
import java.util.function.UnaryOperator;

public class PrimitiveUnaryOperator {

    public static void main(String[] args) {
//        Function<Integer, Integer> f = i -> i * i;
//        If generics Input and Return types are same type, then we should go for UnaryOperator
//        UnaryOperator is a child of Function<T, T>
//        IntUnaryOperator public long applyAsInt
//        LongUnaryOperator public long applyAsLong
//        DoubleUnaryOperator public double applyAsDouble

        UnaryOperator<Integer> f1 = i -> i * i;
        IntUnaryOperator f2 = i -> i + i;

        System.out.println(f1.apply(10));
        System.out.println(f2.applyAsInt(20));
    }
}
