package java7;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CatchingMultipleExceptions {

    private final static Logger LOGGER = Logger.getLogger(CatchingMultipleExceptions.class.getName());

    public static void main(String[] args) {
        beforeJava7();
        withJava7();
    }

    public static void beforeJava7() {
        int arr[] = {1, 2, 3};
        try {
            for (int i = 0; i < arr.length + 1; i++) {
                System.out.println(arr[i]);
            }
        } catch (NullPointerException | ArrayIndexOutOfBoundsException npe) {
            LOGGER.log(Level.SEVERE, npe.toString());
        }
    }

    public static void withJava7() {
        int arr[] = {1, 2, 3};
        try {
            for (int i = 0; i < arr.length + 1; i++) {
                System.out.println(arr[i]);
            }
        } catch (NullPointerException | ArrayIndexOutOfBoundsException ex) {
            LOGGER.log(Level.SEVERE, ex.toString());
            System.err.println(ex.toString());
        }
    }


}
