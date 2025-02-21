package java8.lambda.collections;

import java.util.TreeSet;

public class TreeSetSorting {

    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<>((a, b) -> a > b ? -1 : a < b ? 1 : 0);
        treeSet.add(50);
        treeSet.add(10);
        treeSet.add(25);
        treeSet.add(75);
        treeSet.add(39);
        treeSet.add(0);

//        Collections.sort(treeSet, (a, b) -> a > b ? -1 : a < b ? 1 : 0);

        System.out.println(treeSet);
    }


}
