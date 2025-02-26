package java8.lambda.collections;

import java.util.ArrayList;
import java.util.Collections;

public class ListSorting {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(50);
        list.add(10);
        list.add(25);
        list.add(75);
        list.add(39);
        list.add(0);

        Collections.sort(list, (a, b) -> a < b ? -1 : a > b ? 1 : 0);

        System.out.println(list);
    }


}
