package com.cyclic.barrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
class Task implements Runnable{
	CyclicBarrier barrier=null;
	public Task(CyclicBarrier barrier) {
		this.barrier=barrier;
	}
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+" waiting");
		try {
			System.out.println(barrier.await());
			
		} catch (InterruptedException | BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(Thread.currentThread().getName()+" Done");

	}
}
public class CyclicBarrierTest {
	public static void main(String[] args) {
		CyclicBarrier barrier=new CyclicBarrier(3,new Runnable() {

			@Override
			public void run() {
				System.out.println("barrier Crossed");			
			}
		});
		
		Thread t1=new Thread(new Task(barrier));
		Thread t2=new Thread(new Task(barrier));
		Thread t3=new Thread(new Task(barrier));
t1.start();
t2.start();
t3.start();
 t1=new Thread(new Task(barrier));
 t2=new Thread(new Task(barrier));
 t3=new Thread(new Task(barrier));
t1.start();
t2.start();
t3.start();
	}
}
