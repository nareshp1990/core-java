package com.naresh.producer.consumer.problem;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerDemo {


    public static void main(String args[]) throws InterruptedException {

        Buffer buffer = new Buffer(2);

        Thread producerThread = new Thread(() -> {
            try {
                buffer.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread consumerThread = new Thread(() -> {
            try {
                buffer.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


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


        public void produce()throws InterruptedException{

            int value = 0;
            while (true){

                synchronized (this){

                    if (list.size() >= size){
                        wait();
                    }
                    list.add(value);
                    notify();
                    value++;
                    Thread.sleep(1000);
                }

            }

        }

        public void consume()throws InterruptedException{

            while (true){
                synchronized (this){

                    if (list.size() == 0){
                        wait();
                    }

                    Integer integer = list.poll();

                    System.out.println(integer);

                    notify();
                    Thread.sleep(1000);

                }
            }

        }

    }

}
