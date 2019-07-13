package com.naresh.overloading.run;

public class Example extends Thread {

	public static void main(String[] args) {

		Example obj = new Example();
		obj.start();
		//		obj.setPriority(Thread.MAX_PRIORITY);
		//		obj.setDaemon(true);
		try {
			obj.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Thread State : " + obj.getState());
	}

	public void run(String msg) {
		System.out.println("msg = " + msg);
	}

  /*@Override
  public synchronized void start() {
         System.out.println("Our Start Method");
  }*/

	@Override
	public void run() {
		System.out.println("Original Run Method");
		System.out.println("Thread Name : " + Thread.currentThread().getName());
		System.out.println("Thread State : " + Thread.currentThread().getState());
		System.out.println("Thread Priority : " + Thread.currentThread().getPriority());
		System.out.println("Thread Group : " + Thread.currentThread().getThreadGroup().getName());
		System.out.println(
				"Thread Group Parent : " + Thread.currentThread().getThreadGroup().getParent().getName());
	}
}
