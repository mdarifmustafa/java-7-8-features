package java8.lambda.predefined.functional.interfaces.function;

import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;

public class Authenticating {

    public static void main(String[] args) {

        try (Scanner scan = new Scanner(System.in)) {
            System.out.print("Please enter your username: ");
            String user = scan.next();

            System.out.print("Please enter your password: ");
            String pwd = scan.next();

            Function<String, String> userFirst5Chars = s -> s.substring(0, 4);
            Function<String, String> userInLowerCase = s -> s.toLowerCase();

            Predicate<String> equalsErum = s -> s.equals("erum");
            Predicate<String> equalsAdil = s -> s.equals("adil");

            if (equalsErum.test(userFirst5Chars.andThen(userInLowerCase).apply(user)) && equalsAdil.test(pwd)) {
                System.out.println("Valid User!");
            } else {
                System.err.println("Invalid User!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
