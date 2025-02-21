package java8.lambda.predefined.functional.interfaces.primitive.functions;

public class AllPrimitiveFunctions {

    public static void main(String[] args) {
        System.out.println("All Primitive Functions\n------------------------------");
        System.out.println("IntFunction<R> public R apply(int i)");
        System.out.println("LongFunction<R> public R apply(long l)");
        System.out.println("DoubleFunction<R> public R apply(double d)");
        System.out.println("ToIntFunction<T> public int applyAsInt(T t)");
        System.out.println("ToLongFunction<T> public long applyAsLong(T t)");
        System.out.println("ToDoubleFunction<T> public double applyAsDouble(T t)");
        System.out.println("IntToLongFunction public long applyAsLong(int i)");
        System.out.println("IntToDoubleFunction public double applyAsDouble(double d)");
        System.out.println("LongToIntFunction public int applyAsInt(long l)");
        System.out.println("LongToDoubleFunction public double applyAsDouble(long l)");
        System.out.println("DoubleToIntFunction public int applyAsInt(double d)");
        System.out.println("DoubleToLongFunction public int applyAsLong(double d)");
        System.out.println("ToIntBiFunction<T, U> public int applyAsInt(T t, U u)");
        System.out.println("ToLongBiFunction<T, U> public long applyAsLong(T t, U u)");
        System.out.println("ToDoubleBiFunction<T, U> public double applyAsDouble(T t, U u)");

    }
}
