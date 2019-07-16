package com.naresh.deadlock;

/**
 * Created by IntelliJ IDEA.
 * User: Naresh.P (GSIHYD-1298)
 * Date: 16/7/19
 * Time: 12:47 PM
 */
public class SyncThread implements Runnable {

    private Object obj1;
    private Object obj2;

    public SyncThread(Object obj1, Object obj2) {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    @Override
    public void run() {

        String name = Thread.currentThread().getName();

        System.out.println(name + " Trying to acquire lock on "+ obj1);
        synchronized (obj1){

            System.out.println(name + " acquired lock on "+obj1);

            work();

            System.out.println(name + " Trying to acquire lock on "+obj2);

            synchronized (obj2) {

                System.out.println(name + " acquired lock on "+obj2);

                work();
            }

            System.out.println(name + " released lock on "+obj2);

        }

        System.out.println(name + " released lock on "+obj1);
        System.out.println(name + " finished execution");

    }

    private void work(){
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
