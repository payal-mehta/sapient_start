package com.cyclic.barrier;

public class CustomCyclicBarrierEvent implements Runnable{
	@Override
	public void run() {
		System.out.println("Barrier Crossed");

	}
}
