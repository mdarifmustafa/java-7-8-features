package java7;

import java.util.logging.Logger;

public class RethrowExceptions {

    private final static Logger LOGGER = Logger.getLogger(CatchingMultipleExceptions.class.getName());

    public static void main(String[] args) throws Exception {
        beforeJava7("First");
        withJava7("First");
    }

    public static void beforeJava7(String exceptionName) throws Exception {
        try {
            if (exceptionName.equals("First")) {
                throw new FirstException();
            } else {
                throw new SecondException();
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public static void withJava7(String exceptionName) throws FirstException, SecondException {
        try {
            if (exceptionName.equals("First")) {
                throw new FirstException();
            } else {
                throw new SecondException();
            }
        } catch (Exception e) {
            throw e;
        }
    }


    static class FirstException extends Exception {
    }

    static class SecondException extends Exception {
    }

}
