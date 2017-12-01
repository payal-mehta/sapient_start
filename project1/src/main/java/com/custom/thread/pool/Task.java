package com.custom.thread.pool;

import java.lang.Thread.UncaughtExceptionHandler;

public class Task implements Runnable{

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+" Started Executing");
		try {
			Thread.currentThread().sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(true)
			throw new NullPointerException();
		System.out.println(Thread.currentThread().getName()+" Completed");

	}

	/*@Override
	public void uncaughtException(Thread t, Throwable e) {
		System.out.println("in uncaughtException "+e.getStackTrace()+" Thread Name"+t.currentThread().getName());		
	}*/

}
