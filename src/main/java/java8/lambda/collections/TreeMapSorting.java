package java8.lambda.collections;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapSorting {

    public static void main(String[] args) {
        Map<Integer, String> map = new TreeMap<>((a, b) -> (a > b) ? -1 : (a < b) ? 1 : 0);
        map.put(50, "Arif");
        map.put(10, "Suhail");
        map.put(25, "Wahid");
        map.put(75, "Shahid");
        map.put(39, "Arman");
        map.put(0, "Asif");

        System.out.println(map);
    }


}
