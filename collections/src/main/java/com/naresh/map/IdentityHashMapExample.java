package com.naresh.map;

import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Objects;

public class IdentityHashMapExample {

    public static void main(String[] args) {

        Map<Sample, String> identityHashMap = new IdentityHashMap<>();

        identityHashMap.put(null, "4");
        identityHashMap.put(new Sample("Hello"), "1");
        identityHashMap.put(new Sample("Hello"), "2");
        identityHashMap.put(new Sample("Hello"), "3");

        System.out.println("identityHashMap = " + identityHashMap);

    }


    private static class Sample {

        private String name;

        public Sample(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Sample sample = (Sample) o;
            return Objects.equals(name, sample.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }
}
