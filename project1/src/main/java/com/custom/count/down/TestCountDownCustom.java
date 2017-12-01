package com.custom.count.down;


public class TestCountDownCustom {
	public static void main(String[] args) throws InterruptedException {
		CustomCountDown countDownLatch=new CustomCountDown(13);
		for(int i=0;i<13;i++){
			new Thread(new Runnable() {

				@Override
				public void run() {
					countDownLatch.countDown();
				}
			}).start();
		}
		countDownLatch.await();
		System.out.println("in main");

	}
}
