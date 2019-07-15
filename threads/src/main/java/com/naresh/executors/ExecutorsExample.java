package com.naresh.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by IntelliJ IDEA.
 * User: Naresh.P (GSIHYD-1298)
 * Date: 15/7/19
 * Time: 10:57 AM
 */
public class ExecutorsExample {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Future<?> future = executorService.submit(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " : " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        executorService.shutdown();

        while (!future.isDone()){
            System.out.println("### Task not yet completed ###");
        }
        System.out.println("### Task completed ###");


//        executorService.submit(()-> System.out.println("New Task Will Not Accept after shutdown"));

    }

}
