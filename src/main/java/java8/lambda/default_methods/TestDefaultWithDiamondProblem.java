package java8.lambda.default_methods;


interface Left {
    public default void m1() {
        System.out.println("Left Interface m1");
    }

    public default void m2() {
        System.out.println("Left m2: I'm supposed to not get used!");
    }

    public default void m4() {
        System.out.println("Left Interface m4");
    }
}

interface Right {
    public default void m1() {
        System.out.println("Right Interface m1");
    }

    public default void m3() {
        System.out.println(("Right m3: I don't need implementation, but could use as object!"));
    }

    public default void m4() {
        System.out.println("Right Interface m4");
    }
}

public class TestDefaultWithDiamondProblem implements Left, Right {

    // you can tackle diamond problem using default methods but can't do with abstract method directly in implementation class.
    // you can use without implementation and also could override under class and also if not required then not use.
    // when you tackle diamond problem, you must write one override method.

    public static void main(String[] args) {
        TestDefaultWithDiamondProblem testObject = new TestDefaultWithDiamondProblem();
        testObject.m1();
        testObject.m3();
        testObject.m4();
    }

    // In 1.8, you are not required mandatory to write @Override annotation.
    public void m4() {
        System.out.println("Class level m4: I will not use any Left or Right Interface, but use my own method of similar name and could eliminate implementation!");
    }

    @Override
    public void m1() {
        System.out.println("Overridden m1 method to resolve diamond problem!");
        Left.super.m1();
    }
}
