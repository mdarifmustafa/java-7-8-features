package java8.lambda.predefined.functional.interfaces.primitive.supplier;

import java.util.function.IntSupplier;

public class BasicPrimitiveSupplier {

    public static void main(String[] args) {
        IntSupplier s = () -> (int) (Math.random() * 10);
        // LongSupplier public long getAsLong()
        // DoubleSupplier public double getAsDouble()
        // BooleanSupplier public boolean getAsBoolean()

        String otp = "";
        for (int i = 0; i < 8; i++) {
            otp = otp + s.getAsInt();
        }

        System.out.println(otp);


    }
}
