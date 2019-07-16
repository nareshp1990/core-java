package com.naresh.producer.consumer.problem;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by IntelliJ IDEA.
 * User: Naresh.P (GSIHYD-1298)
 * Date: 16/7/19
 * Time: 3:49 PM
 */
public class ProducerConsumerMain {

    public static void main(String[] args) {

        BlockingQueue<Integer> sharedQueue = new LinkedBlockingQueue<>();

        Thread producer = new Thread(new Producer(sharedQueue),"Producer");
        Thread consumer = new Thread(new Consumer(sharedQueue),"Consumer");

        producer.start();

        consumer.start();


    }
}
