package java8.lambda.predefined.functional.interfaces.primitive.consumer;

import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;

public class BasicPrimitiveConsumer {

    public static void main(String[] args) {
        IntConsumer intConsumer = i -> System.out.println(i * i);
        LongConsumer longConsumer = l -> System.out.println(l * l);
        DoubleConsumer doubleConsumer = d -> System.out.println(d * d);

        intConsumer.accept(10);
        longConsumer.accept(9087L);
        doubleConsumer.accept(17.30f);
    }
}
