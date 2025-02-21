package java8.lambda.static_methods;

interface StaticInterface {
    public static void m1() {
        System.out.println("this is StaticInterface m1");
    }
}

public class StaticOverrideClass implements StaticInterface {

    // you can only call StaticInterface method m1, corresponding to Interface StaticInterface, otherwise no overriding or getting called from class
    public static void main(String[] args) {
        StaticInterface.m1();
    }
}
