package com.naresh.producer.consumer.problem;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerExample {

    public static void main(String args[]) throws InterruptedException {

        Buffer buffer = new Buffer(2);

        Thread producerThread = new Thread(()->{
            try {
                buffer.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"ProducerThread");

        Thread consumerThread = new Thread(()->{
            try {
                buffer.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"ConsumerThread");

        producerThread.start();
        consumerThread.start();

        producerThread.join();
        consumerThread.join();

    }

    static class Buffer{

        private Queue<Integer> list;
        private int size;
        public Buffer(int size) {
            this.list = new LinkedList<>();
            this.size = size;
        }
        public void produce() throws InterruptedException {
            int value = 0;
            while (true) {
                synchronized (this) {
                    while (list.size() >= size) {
                        // wait for the consumer
                        wait();
                        System.out.println(Thread.currentThread().getName() + " waiting for notification ");
                    }
                    System.out.println(Thread.currentThread().getName() + " got Notified ");
                    list.add(value);
                    System.out.println("Produced " + value);
                    value++;
                    // notify the consumer
                    notify();
                    Thread.sleep(1000);
                }
            }
        }
        public void consume() throws InterruptedException {
            while (true) {
                synchronized (this) {
                    while (list.size() == 0) {
                        // wait for the producer
                        wait();
                        System.out.println(Thread.currentThread().getName() + " waiting for notification ");
                    }
                    System.out.println(Thread.currentThread().getName() + " got Notified ");
                    int value = list.poll();
                    System.out.println("Consumed " + value);
                    // notify the producer
                    notify();
                    Thread.sleep(1000);
                }
            }
        }

    }

}
