package com.naresh.volatileexample;

public class VolatileThread extends Thread {

    private final VolatileTest test;
    private final static int TOTAL_THREADS = 2;

    public VolatileThread(VolatileTest test) {
        this.test = test;
    }

    @Override
    public void run() {

        int oldVal = test.getCntValue();

        System.out.println("[Thread " + Thread.currentThread().getName()
                + "]: Old value = " + oldVal);

        test.incrementCnt();

        int newVal = test.getCntValue();

        System.out.println("[Thread " + Thread.currentThread().getName()
                + "]: New value = " + newVal);

    }


    public static void main(String[] args) throws InterruptedException {

        VolatileTest volatileTest = new VolatileTest();

        Thread[] threads = new Thread[TOTAL_THREADS];

        for(int i = 0; i < TOTAL_THREADS; ++i)
            threads[i] = new VolatileThread(volatileTest);

        for(int i = 0; i < TOTAL_THREADS; ++i)
            threads[i].start();

        for(int i = 0; i < TOTAL_THREADS; ++i)
            threads[i].join();
    }


}
