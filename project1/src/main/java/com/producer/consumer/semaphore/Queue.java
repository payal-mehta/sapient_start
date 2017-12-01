package com.producer.consumer.semaphore;

import java.util.LinkedList;
import java.util.concurrent.Semaphore;

public class Queue {
	java.util.Queue<Integer> sharedQueue=new LinkedList<>();
	Semaphore semProd=new Semaphore(1);
	Semaphore semCon=new Semaphore(0);
	int maxsize=0;
	Queue(int maxsize){
		this.maxsize=maxsize;
	}
	void get()
	{
		try {
			semCon.acquire();
		} 
		catch(InterruptedException e) {
			System.out.println("InterruptedException caught");
		}

		System.out.println("Consumer consumed item : " + sharedQueue.remove());
			semProd.release();
	}

	void put(int item)
	{
		try {
			semProd.acquire();
		} catch(InterruptedException e) {
			System.out.println("InterruptedException caught");
		}

		this.sharedQueue.add(item);

		System.out.println("Producer produced item : " + item);

		semCon.release();
	}
}

