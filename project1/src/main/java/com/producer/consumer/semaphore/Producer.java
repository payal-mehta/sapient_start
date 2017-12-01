package com.producer.consumer.semaphore;

import java.util.concurrent.Semaphore;

public class Producer implements Runnable {
	Queue q;

	Producer(Queue q) {
        this.q = q;
        new Thread(this, "Producer").start();
    }
     
    public void run() {
        for(int i=0; i < 5000; i++) {
        	q.put(i);
        }
      
	}

}
