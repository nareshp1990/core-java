package com.naresh.join;

/**
 * Created by IntelliJ IDEA.
 * User: Naresh.P (GSIHYD-1298)
 * Date: 15/7/19
 * Time: 5:14 PM
 */
public class JoinDemo {


    static class ParallelTask implements Runnable{

        Thread processor;

        public void setProcessor(Thread processor) {
            this.processor = processor;
        }

        @Override
        public void run() {

            System.out.println("### " + Thread.currentThread().getName() +  " started ###");

            if (processor!=null){
                try {
                    processor.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("### " + Thread.currentThread().getName() +  " completed ###");

        }
    }

    public static void main(String[] args) {

        ParallelTask task1 = new ParallelTask();
        ParallelTask task2 = new ParallelTask();
        ParallelTask task3 = new ParallelTask();

        Thread t1 = new Thread(task1,"Thread-1");
        Thread t2 = new Thread(task2,"Thread-2");
        Thread t3 = new Thread(task3,"Thread-3");

        task2.setProcessor(t1);
        task3.setProcessor(t2);

        t1.start();
        t2.start();
        t3.start();

        t3.interrupt();

    }

}
