package com.naresh.producer.consumer.problem;

import java.util.concurrent.BlockingQueue;

/**
 * Created by IntelliJ IDEA.
 * User: Naresh.P (GSIHYD-1298)
 * Date: 16/7/19
 * Time: 3:48 PM
 */
public class Consumer implements Runnable {

    private BlockingQueue<Integer> sharedQueue;


    public Consumer(BlockingQueue<Integer> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {

        while (true){

            try {
                Integer value = sharedQueue.take();
                System.out.println(value);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
