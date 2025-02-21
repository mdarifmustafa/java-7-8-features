package java7;

public class StringsInSwitch {
    public static void main(String[] args) {
        String color = "red";
        switch (color) {
            case "red":
                System.out.println("It's red!");
                break;
            case "blue":
                System.out.println("It's blue!");
                break;
            default:
                System.out.println("Unknown color");
        }
    }
}
