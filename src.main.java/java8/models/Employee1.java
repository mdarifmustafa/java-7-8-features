package java8.models;

import java.util.Objects;

public class Employee1 {
    public String name;
    public String designation;
    public double salary;
    public String city;

    public Employee1(String name, String designation, double salary, String city) {
        this.name = name;
        this.designation = designation;
        this.salary = salary;
        this.city = city;
    }

    @Override
    public String toString() {
        String s = String.format("(%s, %s, %.2f, %s)", name, designation, salary, city);

        return s;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee1 employee1 = (Employee1) o;
        return Double.compare(salary, employee1.salary) == 0 && Objects.equals(name, employee1.name) && Objects.equals(designation, employee1.designation) && Objects.equals(city, employee1.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, designation, salary, city);
    }
}
