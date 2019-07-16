package com.naresh.producer.consumer.problem;

import java.util.concurrent.BlockingQueue;

/**
 * Created by IntelliJ IDEA.
 * User: Naresh.P (GSIHYD-1298)
 * Date: 16/7/19
 * Time: 3:46 PM
 */
public class Producer implements Runnable {

    private BlockingQueue<Integer> sharedQueue;

    public Producer(BlockingQueue<Integer> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {
            try {
                sharedQueue.put(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}
