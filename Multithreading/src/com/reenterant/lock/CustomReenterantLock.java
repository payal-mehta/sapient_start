package com.reenterant.lock;


public class CustomReenterantLock {
	int hasCount;
	Thread thread;
	public synchronized void lock() {
		if(hasCount==0){
			thread=Thread.currentThread();
			hasCount++;
		}
	}
	
}
