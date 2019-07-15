package com.naresh.cyclicbarrier;

import java.util.concurrent.*;

public class CyclicBarrierExample {

    public static void main(String args[]){

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        CyclicBarrier barrier = new CyclicBarrier(3);

        executorService.submit(new Task(barrier));
        executorService.submit(new Task(barrier));
        executorService.submit(new Task(barrier));

        executorService.shutdown();

        System.out.println("Main finished");

    }

    public static class Task implements Runnable{

        private CyclicBarrier barrier;

        public Task(CyclicBarrier barrier) {
            this.barrier = barrier;
        }

        @Override
        public void run() {

            System.out.println(Thread.currentThread().getName() + " job has started");

            try {
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + " job has completed");

        }
    }

}
