package com.naresh.stop.resume.suspend;

public class ExampleThread implements Runnable {

    private Thread thread;
    private boolean isStopped;
    private boolean isSuspended;

    public ExampleThread(String name) {

        this.thread = new Thread(this,name);
        this.isStopped = false;
        this.isSuspended = false;

        this.thread.start();

    }

    @Override
    public void run() {

        try {
            for (int i = 1; i < 10; i++) {
                System.out.println(".");
                Thread.sleep(1000);
                synchronized (this) {
                    while (isSuspended){
                        wait();
                    }
                    if (isStopped){
                        break;
                     }
                }
            }
        } catch (InterruptedException exc) {
            System.out.println(thread.getName() + " interrupted.");
        }
        System.out.println("\n" + thread.getName() + " exiting.");

    }

    synchronized void stop() {
        isStopped = true;
        isSuspended = false;
        notify();
    }

    synchronized void suspend() {
        isSuspended = true;
    }

    synchronized void resume() {
        isSuspended = false;
        notify();
    }

}
