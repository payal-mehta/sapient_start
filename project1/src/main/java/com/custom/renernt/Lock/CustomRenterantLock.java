package com.custom.renernt.Lock;

public class CustomRenterantLock {
	long threadId;
	int lockHoldCount;
	public synchronized void lock() throws InterruptedException{
		if(lockHoldCount==0){
			lockHoldCount++;
			threadId=Thread.currentThread().getId();
		}else if(lockHoldCount>=0 || threadId==Thread.currentThread().getId()){
			lockHoldCount++;
		}else {
			lockHoldCount++;
			threadId=Thread.currentThread().getId();
			this.wait();
		}
		System.out.println("lock lockHoldCount  ::"+lockHoldCount);

	}
	public synchronized void unlock(){
		if(lockHoldCount>0){
			lockHoldCount--;
			notify();
		}
		else{
			throw new IllegalThreadStateException();
		}
		System.out.println("Unlock lockHoldCount  ::"+lockHoldCount);

	}
	
	public boolean tryLock(){
		if(lockHoldCount==0){
			return true;
		}
		return false;
	}

}
