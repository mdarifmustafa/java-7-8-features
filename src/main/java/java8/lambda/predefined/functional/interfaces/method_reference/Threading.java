package java8.lambda.predefined.functional.interfaces.method_reference;


public class Threading {

    public static void main(String[] args) {
        Threading threading = new Threading();

        Runnable runnable = threading::runThread;

        Thread thread = new Thread(runnable);
        thread.start();

        for (int i = 0; i < 100; i++) {
            System.out.println("Main Thread: " + i);
        }
    }

    public void runThread() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Runnable: " + i);
        }
    }
}
