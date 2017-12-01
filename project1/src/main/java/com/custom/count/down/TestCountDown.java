package com.custom.count.down;

import java.util.concurrent.CountDownLatch;

public class TestCountDown {
	public static void main(String[] args) throws InterruptedException {
		CountDownLatch countDownLatch=new CountDownLatch(3);
		for(int i=0;i<3;i++){
			new Thread(new Runnable() {

				@Override
				public void run() {
					System.out.println("Count Down Latch"+ countDownLatch.getCount());	
					countDownLatch.countDown();
				}
			}).start();
		}
		countDownLatch.await();
		System.out.println("in main");

	}
}
