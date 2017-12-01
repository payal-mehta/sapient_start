package com.custom.blocking.queue;


public class Producer implements Runnable {
	CustomBlockingQueue<Integer> sharedQueue=null;
	private String name;

	public Producer(CustomBlockingQueue<Integer> sharedQueue, String name) {
		this.sharedQueue=sharedQueue;
		this.name=name;
	}
	@Override
	public void run() {
		Thread.currentThread().setName(name);
        for(int i=1; i<=1000000; i++){
			sharedQueue.put(i);
			System.out.println("Producer Produced");
		}
	}
}


