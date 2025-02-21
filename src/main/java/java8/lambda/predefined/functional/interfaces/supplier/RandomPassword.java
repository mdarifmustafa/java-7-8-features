package java8.lambda.predefined.functional.interfaces.supplier;

import java.util.function.Supplier;

public class RandomPassword {

    public static void main(String[] args) {

        Supplier<String> randomPassword = () -> {
            String pwd = "";

            Supplier<Integer> d = () -> (int) (Math.random() * 10);

            String symbols = "ABCDEFGHIJKLMNOPQRSTUVWXYZ@#$";

            Supplier<Character> c = () -> symbols.charAt((int) (Math.random() * 29));

            for (int i = 0; i < 8; i++) {
                if (i % 2 == 0) {
                    pwd += d.get();
                } else {
                    pwd += c.get();
                }
            }
            return pwd;
        };


        System.out.println("Random Password is: " + randomPassword.get());
        System.out.println("Random Password is: " + randomPassword.get());
        System.out.println("Random Password is: " + randomPassword.get());
        System.out.println("Random Password is: " + randomPassword.get());
        System.out.println("Random Password is: " + randomPassword.get());
        System.out.println("Random Password is: " + randomPassword.get());
    }
}
