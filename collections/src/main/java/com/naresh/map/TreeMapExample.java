package com.naresh.map;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapExample {

    public static void main(String[] args) {

        Map<Integer,String> treeMap = new TreeMap(Comparator.reverseOrder());

        treeMap.put(2, "World");
        treeMap.put(1, "Hello");
        treeMap.put(4, "...");
        treeMap.put(3, "!");
        treeMap.put(18, "!!!");
//        treeMap.put(null,"2");

        System.out.println("treeMap = " + treeMap);

    }

}
