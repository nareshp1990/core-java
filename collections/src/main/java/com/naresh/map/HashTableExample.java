package com.naresh.map;

import java.util.Hashtable;
import java.util.Map;

public class HashTableExample {

    public static void main(String[] args) {

        Map<Integer,String> hashTable = new Hashtable<>();

//        hashTable.put(null,"2");
        hashTable.put(1,"1");
        hashTable.put(119,"1");

        System.out.println("hashTable = " + hashTable);

    }

}
