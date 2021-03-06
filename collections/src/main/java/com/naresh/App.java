package com.naresh;

import java.util.Objects;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        Sample hello = new Sample("Hello");
        Sample hello1 = new Sample("Hello");

        System.out.println(hello.hashCode());
        System.out.println(hello1.hashCode());

        if (hello.hashCode() == hello1.hashCode()){
            System.out.println("Hash codes are equal");
        }

    }

    static class Sample{
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
