package java7;

import java.util.ArrayList;
import java.util.List;

public class DiamondOperator {
    public static void main(String[] args) {
        // Before Java 7
        List<String> list1 = new ArrayList<String>();

        // Java 7 (Diamond Operator)
        List<String> list2 = new ArrayList<>();

        System.out.println("List1: " + list1);
        System.out.println("List2: " + list2);
    }
}
