package com.naresh.map;

import java.util.EnumMap;
import java.util.Map;

public class EnumMapExample {

    public static void main(String[] args) {

        Map<DayOfWeek, String> enumMap = new EnumMap<>(DayOfWeek.class);

//        enumMap.put(null, "NULL");
        enumMap.put(DayOfWeek.MONDAY, "Monday");

        System.out.println("enumMap = " + enumMap);

    }

    public enum DayOfWeek {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }

}
