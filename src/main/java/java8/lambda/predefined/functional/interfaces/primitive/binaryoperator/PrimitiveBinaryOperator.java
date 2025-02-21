package java8.lambda.predefined.functional.interfaces.primitive.binaryoperator;

import java.util.function.BinaryOperator;
import java.util.function.DoubleBinaryOperator;
import java.util.function.IntBinaryOperator;

public class PrimitiveBinaryOperator {

    public static void main(String[] args) {
//        BiFunction<T, U, R>
//        BiFunction<Integer, Integer Integer> f = (i1, i2) -> i * i;
//        If generics both Inputs and Return types are same type, then we should go for BinaryOperator
//        BinaryOperator is a child of BiFunction<T, T, T>
//        IntBinaryOperator public long applyAsInt
//        LongBinaryOperator public long applyAsLong
//        DoubleBinaryOperator public double applyAsDouble

        BinaryOperator<Integer> f1 = (i1, i2) -> i1 + i2;
        IntBinaryOperator f2 = (i1, i2) -> i1 + i2;
        DoubleBinaryOperator f3 = (d1, d2) -> Math.pow(d1, d2);

        System.out.println(f1.apply(10, 20));
        System.out.println(f2.applyAsInt(10, 20));
        System.out.println(f3.applyAsDouble(20.67f, 4.5f));
    }
}
