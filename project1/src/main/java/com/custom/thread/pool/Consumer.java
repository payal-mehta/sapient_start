package com.custom.thread.pool;

import java.util.Queue;

public class Consumer implements Runnable {
	Queue<Integer> sharedQueue=null;
	private String name;
	
	public Consumer(Queue<Integer> sharedQueue, String name) {
		this.sharedQueue=sharedQueue;
		this.name=name;
	}
	@Override
	public void run() {
		Thread.currentThread().setName(name);
		while(true){

			synchronized (sharedQueue) {
				if(!sharedQueue.isEmpty()){
					sharedQueue.remove();
					System.out.println(Thread.currentThread().getName()+" Consumed Size:"+sharedQueue.size());
					sharedQueue.notifyAll();
				}
				else{
					try {
						sharedQueue.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}

		}
	}

}
