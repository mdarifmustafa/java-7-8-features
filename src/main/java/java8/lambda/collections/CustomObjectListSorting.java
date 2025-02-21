package java8.lambda.collections;

import java8.models.Employee;

import java.util.ArrayList;
import java.util.List;

public class CustomObjectListSorting {

    public static void main(String[] args) {
        List<Employee> list = new ArrayList();

        list.add(new Employee(0, "RajKumar"));
        list.add(new Employee(50, "Shariff"));
        list.add(new Employee(100, "Marsh"));
        list.add(new Employee(150, "Albestor"));
        list.add(new Employee(200, "Leena"));
        list.add(new Employee(250, "Warun"));

        System.out.println("Before Sorting" + list);

        list.sort((a, b) -> (a.eno > b.eno) ? 1 : (a.eno < b.eno) ? -1 : 0);

        System.out.println("After Sorting" + list);

    }
}
