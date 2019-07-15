package com.naresh.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CountDownLatchExample {

    public static void main(String args[]){

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        CountDownLatch countDownLatch = new CountDownLatch(3);

        executorService.submit(new DependentService(countDownLatch));
        executorService.submit(new DependentService(countDownLatch));
//        executorService.submit(new DependentService(countDownLatch));
//        executorService.submit(new DependentService(countDownLatch));

        try {
            countDownLatch.await(30, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        executorService.shutdown();

        System.out.println("Main finished");


    }

    public static class DependentService implements Runnable{

        private CountDownLatch latch;

        public DependentService(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {

            System.out.println(Thread.currentThread().getName() + " job has started");

            latch.countDown();

            System.out.println(Thread.currentThread().getName() + " job has completed");

        }
    }

}
