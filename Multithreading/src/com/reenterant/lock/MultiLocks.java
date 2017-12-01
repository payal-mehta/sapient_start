package com.reenterant.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MultiLocks {

	ReentrantLock l1=new ReentrantLock();
	private void test1()  {
		l1.lock();
		System.out.println(Thread.currentThread().getName()+" in test1");
		try {
			Thread.currentThread().sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test2();
		l1.unlock();
	}
	private void test2() {
		l1.lock();
		System.out.println(Thread.currentThread().getName()+" in test2");
		if(l1.isHeldByCurrentThread())
			l1.unlock();

		
	}
	public static void main(String[] args)  {
		MultiLocks locks=new MultiLocks();
		Thread t1=new Thread(()->locks.test1());
		t1.start();
		Thread t2=new Thread(()->locks.test2());
		t2.start();
		
	}
}
