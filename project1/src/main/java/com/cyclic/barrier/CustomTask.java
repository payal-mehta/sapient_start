package com.cyclic.barrier;



public class CustomTask implements Runnable{
	CustomCyclicBarrier barrier;
	CustomTask(CustomCyclicBarrier barrier){
		this.barrier=barrier;
	}
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+" waiting");
		barrier.await();
		//System.out.println();
		System.out.println(Thread.currentThread().getName()+" Done");

	}
}
