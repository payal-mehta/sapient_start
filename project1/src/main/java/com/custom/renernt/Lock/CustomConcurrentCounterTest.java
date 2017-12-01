package com.custom.renernt.Lock;

public class CustomConcurrentCounterTest {
	public static void main(String[] args) {
		CustomConcurrentCounter concurrentCounter=new CustomConcurrentCounter(new CustomRenterantLock());
		System.out.println("in main");
		Thread t1=new Thread(new Runnable(){
			@Override
			public void run() {
				for(int i=0;i<20;i++){
					System.out.println("in Run " +Thread.currentThread().getName());
					concurrentCounter.getCount();
				}
			}
		});
		t1.start();
		Thread t2=new Thread(new Runnable(){
			@Override
			public void run() {
				for(int i=0;i<10;i++){
					System.out.println("in Run " +Thread.currentThread().getName());
					concurrentCounter.getCount();
				}
			}
		});
		t2.start();
	}
	
}
