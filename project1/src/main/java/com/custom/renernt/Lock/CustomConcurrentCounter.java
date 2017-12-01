package com.custom.renernt.Lock;

public class CustomConcurrentCounter {
	CustomRenterantLock customRenterantLock;
	int count=0;
	public CustomConcurrentCounter(CustomRenterantLock customRenterantLock){
		this.customRenterantLock=customRenterantLock;
	}
	public int getCount() {
			try {
				customRenterantLock.lock();
				System.out.println(count+ " " +Thread.currentThread().getName());
				count++;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally{
				customRenterantLock.unlock();
			}
			return count;

	}
}