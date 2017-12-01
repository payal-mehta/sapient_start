package com.wait.notify;

import java.util.Queue;

public class Producer implements Runnable {
	Queue<Integer> sharedQueue=null;
	private int maxSize;
	private String name;
	
	public Producer(Queue<Integer> sharedQueue, int maxSize, String name) {
		this.sharedQueue=sharedQueue;
		this.maxSize=maxSize;
		this.name=name;
		}
	@Override
	public void run() {
		Thread.currentThread().setName(name);
		while(true){

			synchronized (sharedQueue) {
				if(sharedQueue.size()<maxSize){
					sharedQueue.add(10);
					System.out.println(Thread.currentThread().getName()+" Produced Size:"+sharedQueue.size());
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
