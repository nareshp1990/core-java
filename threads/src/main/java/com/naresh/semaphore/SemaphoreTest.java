package com.naresh.semaphore;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {

    private static Semaphore semaphore = new Semaphore(4);

    static class MyThread extends Thread{

        String name="";

        public MyThread(String name) {
            super(name);
            this.name = name;
        }

        @Override
        public void run() {

            try {


                System.out.println(name + " : acquiring lock...");
                System.out.println(name + " : available Semaphore permits now: "
                        + semaphore.availablePermits());

                semaphore.acquire();
                System.out.println(name + " : got the permit!");

                try {

                    for (int i = 1; i <= 5; i++) {

                        System.out.println(name + " : is performing operation " + i
                                + ", available Semaphore permits : "
                                + semaphore.availablePermits());

                        // sleep 1 second
                        Thread.sleep(1000);

                    }

                } finally {

                    // calling release() after a successful acquire()
                    System.out.println(name + " : releasing lock...");
                    semaphore.release();
                    System.out.println(name + " : available Semaphore permits now: "
                            + semaphore.availablePermits());

                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }


    public static void main(String args[]){

        System.out.println("Total available Semaphore permits : "
                + semaphore.availablePermits());

        MyThread[] threads=new MyThread[5];

        for (int i=0;i<threads.length;i++){

            threads[i] = new MyThread("Thread-"+i);
            threads[i].start();

        }


    }

}
