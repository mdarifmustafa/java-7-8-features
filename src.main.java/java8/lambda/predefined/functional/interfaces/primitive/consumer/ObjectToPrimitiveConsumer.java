package java8.lambda.predefined.functional.interfaces.primitive.consumer;

import java8.models.Employee;
import java8.models.Employee1;

import java.util.function.ObjDoubleConsumer;
import java.util.function.ObjIntConsumer;
import java.util.function.ObjLongConsumer;

public class ObjectToPrimitiveConsumer {

    public static void main(String[] args) {
        ObjIntConsumer<Employee> c1 = (e, i) -> {
            e.eno = e.eno + i;
            System.out.println("Employee0: " + e);
        };

        ObjLongConsumer<Employee1> c2 = (e1, l) -> {
            e1.salary = e1.salary + l;
            System.out.println("Employee1: " + e1);
        };

        ObjDoubleConsumer<Employee1> c3 = (e1, d) -> {
            e1.salary = e1.salary + d;
            System.out.println("Employee2: " + e1);
        };


        Employee emp = new Employee(200, "Aarju");
        Employee1 emp1 = new Employee1("Arif", "Engineer", 5678f, "Bengaluru");
        Employee1 emp2 = new Employee1("Altamas", "Engineer", 5578f, "Hyderabad");

        c1.accept(emp, 300);
        c2.accept(emp1, 500L);
        c3.accept(emp2, 660.87f);


    }
}
