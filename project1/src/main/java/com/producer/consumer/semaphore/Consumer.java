package com.producer.consumer.semaphore;

import java.util.concurrent.Semaphore;

public class Consumer implements Runnable {
	private Queue q=null;
	Consumer(Queue q) {
        this.q = q;
        new Thread(this, "Consumer").start();
    }
     
    public void run() {
        for(int i=0; i < 500000; i++) {
        	q.get();
        }
      
	}

}
