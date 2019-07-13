package com.naresh.interrupt;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadInterrupt {

    public static void main(String[] args) {

        Runnable r =
                () -> {
                    for (int i = 0; i < 10; i++) {

                        System.out.println(i);

                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            System.out.println("### Thread got interrupted ### : " + Thread.currentThread().getState() );
                            break;
                        }
                    }
                };

        /*Thread taskThread = new Thread(r);
        taskThread.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        taskThread.interrupt();

        try {
            taskThread.join(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(r);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        executorService.shutdownNow();

        try {
            executorService.awaitTermination(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
