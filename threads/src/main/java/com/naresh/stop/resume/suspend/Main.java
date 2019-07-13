package com.naresh.stop.resume.suspend;

public class Main {

    public static void main(String args[]) throws Exception {
        ExampleThread mt = new ExampleThread("MyThread");
        Thread.sleep(2000);
        mt.suspend();
        Thread.sleep(2000);

        mt.resume();
        Thread.sleep(2000);

        mt.suspend();
        Thread.sleep(2000);

        mt.resume();
        Thread.sleep(2000);

        mt.stop();
    }

}
