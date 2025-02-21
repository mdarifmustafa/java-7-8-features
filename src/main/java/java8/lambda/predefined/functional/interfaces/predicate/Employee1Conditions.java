package java8.lambda.predefined.functional.interfaces.predicate;

import java8.models.Employee1;

import java.util.ArrayList;
import java.util.function.Predicate;

public class Employee1Conditions {

    public static void populate(final ArrayList<Employee1> list) {
        list.add(new Employee1("Arif", "Managing Director", 40000, "Bengaluru"));
        list.add(new Employee1("Sunny", "CEO", 90000, "Hyderabad"));
        list.add(new Employee1("Adil", "CTO", 40000, "Mumbai"));
        list.add(new Employee1("John", "Manager", 35000, "Chennai"));
        list.add(new Employee1("Emma", "Developer", 38000, "Delhi"));
        list.add(new Employee1("Michael", "Designer", 32000, "Kolkata"));
        list.add(new Employee1("Sophia", "HR", 33000, "Pune"));
        list.add(new Employee1("James", "Accountant", 36000, "Bengaluru"));
        list.add(new Employee1("Olivia", "Manager", 37000, "Hyderabad"));
        list.add(new Employee1("William", "Developer", 39000, "Mumbai"));
        list.add(new Employee1("Ava", "Designer", 31000, "Chennai"));
        list.add(new Employee1("Alexander", "HR", 34000, "Delhi"));
        list.add(new Employee1("Mia", "Accountant", 38000, "Kolkata"));
        list.add(new Employee1("Ethan", "Manager", 32000, "Pune"));
        list.add(new Employee1("Isabella", "Developer", 36000, "Bengaluru"));
        list.add(new Employee1("Daniel", "Designer", 38000, "Hyderabad"));
        list.add(new Employee1("Charlotte", "HR", 33000, "Mumbai"));
        list.add(new Employee1("Matthew", "Accountant", 15000, "Chennai"));
        list.add(new Employee1("Amelia", "Manager", 37000, "Delhi"));
        list.add(new Employee1("Benjamin", "Developer", 39000, "Kolkata"));
        list.add(new Employee1("Aryan", "Designer", 31000, "Pune"));
        list.add(new Employee1("Chloe", "HR", 34000, "Bengaluru"));
        list.add(new Employee1("Lucas", "Accountant", 16000, "Hyderabad"));
        list.add(new Employee1("Evelyn", "Manager", 32000, "Mumbai"));
        list.add(new Employee1("Mason", "Developer", 37000, "Chennai"));
        list.add(new Employee1("Harper", "Designer", 38000, "Delhi"));
        list.add(new Employee1("Elijah", "HR", 33000, "Kolkata"));
        list.add(new Employee1("Suresh", "Manager", 38000, "Bengaluru"));
    }

    public static void display(Predicate<Employee1> p, ArrayList<Employee1> list, String headerMessage) {
        System.out.println(headerMessage + " -");
        for (Employee1 e : list) {
            if (p.test(e))
                System.out.println(e);
        }
        System.out.println("****************************************************************");
    }

    public static void main(String[] args) {
        ArrayList<Employee1> list = new ArrayList<Employee1>();

        populate(list);

        Predicate<Employee1> isManagerPredicate = e -> e.designation.toLowerCase().contains("manager");
        Predicate<Employee1> isCityBengaluruPredicate = e -> e.city.toLowerCase().contains("bengaluru");
        Predicate<Employee1> isSalaryLess20k = e -> e.salary < 20000;
        Predicate<Employee1> isCeo = Predicate.isEqual(new Employee1("Sunny", "CEO", 90000, "Hyderabad"));

        display(isManagerPredicate, list, "List of Managers");
        display(isCityBengaluruPredicate, list, "City is Bengaluru");
        display(isManagerPredicate.and(isCityBengaluruPredicate), list, "Managers living in Bengaluru");
        display(isManagerPredicate.or(isSalaryLess20k), list, "Designation Manager or Salary less than 20k");
        display(isManagerPredicate.negate().and(isCityBengaluruPredicate), list, "Not Managers but living in Bengaluru");
        display(isCeo, list, "Is CEO");
    }
}
