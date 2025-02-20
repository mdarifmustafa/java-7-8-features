package java8.lambda.predefined.functional.interfaces.function;

import java8.models.Student;

import java.util.ArrayList;
import java.util.function.Function;

public class StudentGrade {

    private static void populate(ArrayList<Student> list) {
        list.add(new Student(1, "Asif", new int[]{7, 27, 65}));
        list.add(new Student(2, "Sameer", new int[]{40, 45, 23}));
        list.add(new Student(3, "Suhail", new int[]{50, 85, 93}));
        list.add(new Student(4, "Bittu", new int[]{3, 9, 6}));
        list.add(new Student(5, "Ayaan", new int[]{79, 83, 90}));
    }

    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<>();
        populate(students);

        Function<Student, Integer> totalMarks = s -> s.marks[0] + s.marks[1] + s.marks[2];
        Function<Student, Integer> avgMark = s -> (Integer) totalMarks.apply(s) / 3;
        Function<Student, String> markGrade = s -> {
            Integer avg = avgMark.apply(s);
            return avg > 80 ? "A" : avg > 60 ? "B" : avg > 50 ? "C" : avg >= 35 ? "D" : "E";
        };
        Function<Student, String> gradeResult = s -> {
            switch (markGrade.apply(s)) {
                case "A":
                    return "Distinction";
                case "B":
                    return "First";
                case "C":
                    return "Second";
                case "D":
                    return "Third";
                default:
                    return "Failed";
            }
        };

        for (Student student : students) {
            System.out.print("\n------------------------");
            System.out.printf("\nTotal obtained marks of %s: %d", student.name, totalMarks.apply(student));
            System.out.printf("\nAverage mark of %s: %d", student.name, avgMark.apply(student));
            System.out.printf("\nMark grade of %s: %s", student.name, markGrade.apply(student));
            System.out.printf("\nResult of %s: %s", student.name, gradeResult.apply(student));
        }

    }

}
