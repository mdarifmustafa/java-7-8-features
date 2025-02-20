package java8.lambda.predefined.functional.interfaces.constructor_reference;

interface Customer {
    public Car buy();
}

class Car {
    Car() {
        System.out.println("Car class constructor execution and object creation!");
    }

    public void driving() {
        System.out.println("Customer is happy and driving car!");
    }
}

public class Basic {
    public static void main(String[] args) {
        Customer customer = Car::new;
        Car newCar = customer.buy();
        newCar.driving();
    }
}
