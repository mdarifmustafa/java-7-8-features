package java8.models;

import java.util.Arrays;
import java.util.Objects;

public class Student {
    public String name;
    public int[] marks;
    Integer rollNo;

    public Student(Integer rollNo, String name, int[] marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student{" +
            "rollNo=" + rollNo +
            ", name='" + name + '\'' +
            ", marks=" + Arrays.toString(marks) +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(rollNo, student.rollNo) && Objects.equals(name, student.name) && Arrays.equals(marks, student.marks);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(rollNo, name);
        result = 31 * result + Arrays.hashCode(marks);
        return result;
    }
}
