package com.naresh.map;

import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;

public class WeakHashMapExample {

    public static void main(String[] args) {

        Map<Sample,String> weakHashMap = new WeakHashMap<>();

        weakHashMap.put(null,"4");
        weakHashMap.put(new Sample("Hello"),"1");
        weakHashMap.put(new Sample("Hello"),"2");
        weakHashMap.put(new Sample("Hello"),"3");

        System.out.println("Before GC weakHashMap = " + weakHashMap);

        System.out.println("Before GC weakHashMap = " + weakHashMap.get(new Sample("Hello")));

        System.gc();

        System.out.println("After GC weakHashMap = " + weakHashMap);

    }

    static class Sample{

        private String name;

        public Sample(String name) {
            this.name = name;
        }

        @Override
        protected void finalize() throws Throwable {
            System.out.println("GC got called");
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Sample sample = (Sample) o;
            return Objects.equals(name, sample.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }

}
