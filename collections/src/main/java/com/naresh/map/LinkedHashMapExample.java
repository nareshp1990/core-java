package com.naresh.map;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapExample {

    public static void main(String[] args) {

        Map<Integer, String> linkedHMap = new LinkedHashMap<>();

        linkedHMap.put(null,"4");
        linkedHMap.put(2, "World");
        linkedHMap.put(1, "Hello");
        linkedHMap.put(4, "...");
        linkedHMap.put(3, "!");
        linkedHMap.put(18, "!!!");

        StringBuilder value = new StringBuilder();

        linkedHMap.keySet().stream().forEach(key -> {
            value.append(linkedHMap.get(key));
        });

        System.out.println("value = " + value.toString());

    }

}
