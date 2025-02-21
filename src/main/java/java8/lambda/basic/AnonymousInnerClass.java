package java8.lambda.basic;

public class AnonymousInnerClass {

    public static void main(String[] args) {
        /***
         * Here No Need of writing explicitly,
         * new Runnable() {
         *  for (int i = 0; i < 10; i++) {
         *      for (int i = 0; i < 10; i++) {
         *  }
         * }
         *
         * These all lines directly will get replaced by Lambda Expression
         * ***/

        Thread thread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Child Thread: " + i);
            }
        });

        thread.start();

        for (int i = 0; i < 10; i++) {
            System.out.println("Main Thread: " + i);
        }
    }

}
