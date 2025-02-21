package java8.lambda.predefined.functional.interfaces.method_reference;

import java.util.function.DoubleBinaryOperator;

interface Car {
    public void driving();
}

public class Basic {

    // Method reference is possible, when reference static method like travelling and
    // referer method like driving have similar type input params or both have no params,
    // then it would be possible, even both have different names, but it's allowed!
    // Just Compulsory both methods have same input types!, even if return type, modifier is different it's okay, but input types have to be same.
    // static => classname::method_name
    // instance => object_ref::method_name

    public static void travelling() {
        System.out.println("I'm driving car to travel using method reference!");
    }

    public static void main(String[] args) {
        Basic basicObj = new Basic();

        Car car1 = Basic::travelling;
        car1.driving();

        Car car2 = basicObj::throttling;
        car2.driving();

        // DoubleBinaryOperator dbo = (d1, d2) -> Math.pow(d1, d2); but is also possible using Math::pow;
        // Here DoubleBinaryOperator function definition and Math.pow input params are same, hence the reason, we could use method reference.
        DoubleBinaryOperator dbo = Math::pow;

        System.out.println(dbo.applyAsDouble(2f, 5.5f));
    }

    public void throttling() {
        System.out.println("I'm throttling car to travel using object reference method reference!");
    }
}
