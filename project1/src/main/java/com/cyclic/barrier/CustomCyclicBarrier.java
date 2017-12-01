package com.cyclic.barrier;

public class CustomCyclicBarrier {
	int initialCount;
	volatile int awaitingCount;
	CustomCyclicBarrierEvent barrierEvent;
	public CustomCyclicBarrier(int initialCount,
			CustomCyclicBarrierEvent barrierEvent) {
		super();
		this.initialCount = initialCount;
		this.barrierEvent = barrierEvent;
		awaitingCount=initialCount;
	}
	public synchronized void  await() {
		awaitingCount--;
		if(awaitingCount>0){
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else{
			awaitingCount=initialCount;
			this.notifyAll();
			barrierEvent.run();
		}
	}
}
