package com.custom.count.down;


public class CustomCountDown {
	private  int count;
	public CustomCountDown( int count){
		this.count=count;
	}
	public synchronized void await() throws InterruptedException {
		if(count>0){
			this.wait();
		}
	}
	public synchronized void countDown() {
		count--;
		if(count==0){
			System.out.println("its 0");
			this.notifyAll();
		}
		else
			System.out.println("Count Down Latch"+ count);	

	}
	public int getCount() {
		return count;
	}

}
