package com.naresh.yeild;

public class ThreadYield {

	public static void main(String[] args) {

		Runnable r = () -> {
			int counter = 0;
			while (counter < 2) {
				System.out.println(Thread.currentThread().getName());
				counter++;
//				Thread.yield();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};

		Thread thread1 = new Thread(r,"First Thread");
    	System.out.println("Before start 1 -> : " + thread1.getState());
		thread1.start();
    	System.out.println("After start 1 -> : " + thread1.getState());

		/*try {
			thread1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/

		Thread thread2 = new Thread(r,"Second Thread");
    	System.out.println("After start 1 -> : " + thread1.getState());
    	System.out.println("Before start 2 -> : " + thread2.getState());
		thread2.start();
    	System.out.println("After start 1 -> : " + thread1.getState());
    	System.out.println("After start 2 -> : " + thread2.getState());

	}
}
