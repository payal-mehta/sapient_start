package com.custom.thread.pool;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;

public class Worker implements Runnable{
	
	Queue<Runnable> queue=null;
	Boolean atomicBoolean;
	public Worker(Queue<Runnable> queue, Boolean atomicBoolean){
		this.queue=queue;
		this.atomicBoolean=atomicBoolean;
	}
	@Override
	public void run() {
		while(!atomicBoolean || !queue.isEmpty()){
			if(!queue.isEmpty()){
				Runnable task=queue.remove();
				task.run();
			}
			
		}
	}

}
