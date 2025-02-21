package java8.lambda.predefined.functional.interfaces.primitive.functions;

import java.util.function.DoubleFunction;
import java.util.function.IntToDoubleFunction;

public class FloatingFunctionPrimitive {
    public static void main(String[] args) {

        int[] intArray = {5, 10, 15, 20, 25, 30, 35, 40};
        double[] doubleArray = {-10.5f, -5.0f, 0.0f, 5.0f, 10.0f, 15.0f, 20.67f, 25.32f, 30.87f, 35.10f, 40.0f};

        DoubleFunction<Double> fun1 = i -> i % 3f;
        IntToDoubleFunction fun2 = i -> Math.sqrt(i);


        for (double x : doubleArray) {
            System.out.println(fun1.apply(x));
        }

        for (int x : intArray) {
            System.out.println(fun2.applyAsDouble(x));
        }

    }
}
