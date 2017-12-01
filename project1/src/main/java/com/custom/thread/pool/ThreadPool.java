package com.custom.thread.pool;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class ThreadPool {
	Queue<Runnable> queue=null;
	int fixedThread;
	int currentWorkerCount=0;
	Boolean atomicBoolean=new Boolean(false);
	public ThreadPool(int fixedThread){
		this.fixedThread=fixedThread;
		this.queue=new LinkedBlockingQueue<Runnable>();		
	}
	public void submit(Runnable runnable) {
		if(!atomicBoolean){
			if(currentWorkerCount<fixedThread){
				currentWorkerCount++;
				System.out.println("creating new Worker "+currentWorkerCount);
				new Thread(new Worker(queue, atomicBoolean)).start();
			}
			queue.add(runnable);
		}
		else{
			System.out.println("shuting Down so can not take the task");
		}
	}
	public void shutDown() {
		System.out.println("shuting Down");
		atomicBoolean=(true);	
	}
}
