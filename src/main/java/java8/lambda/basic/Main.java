package java8.lambda.basic;


interface Human {
    public void breath();
}

interface Addition {
    public void add(int a, int b);
}

@FunctionalInterface
interface StringLength {
    public int getLength(String str);
}

public class Main {
    public static void main(String[] args) {

        Human human = () -> System.out.println("Human is breathing!...");
        human.breath();

        Addition addition = (a, b) -> System.out.println("Sum is: " + (a + b));
        addition.add(10, 20);

        StringLength length = str -> str.length();
        System.out.println("Length is: " + length.getLength("Hello"));

        Thread thread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Child Thread: " + i);
            }
        });
        thread.start();

        for (int i = 0; i < 5; i++) {
            System.out.println("Main Thread: " + i);
        }
    }


}