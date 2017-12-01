package com.custom.blocking.queue;


public class Consumer implements Runnable {
	CustomBlockingQueue<Integer> sharedQueue=null;
	private String name;

	public Consumer(CustomBlockingQueue<Integer> sharedQueue, String name) {
		this.sharedQueue=sharedQueue;
		this.name=name;
	}
	@Override
	public void run() {
		Thread.currentThread().setName(name);
		while(true){
			System.out.println("Consumed "+sharedQueue.take());
		}

	}
}


