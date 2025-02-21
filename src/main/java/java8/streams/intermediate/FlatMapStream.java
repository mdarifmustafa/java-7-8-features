package java8.streams.intermediate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class FlatMapStream {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            list.add(i);

        List<Double> doubleList = list.stream()
            .flatMapToDouble(I -> I % 2 == 0 ? DoubleStream.empty() : DoubleStream.of(I, I * 10))
            .boxed()
            .collect(Collectors.toList());

        doubleList.stream().forEach(System.out::println);
    }
}
