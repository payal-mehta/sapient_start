package com.reenterant.lock;

import java.util.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TransferMoney {
	Map<Integer,Bank> map=new HashMap<Integer, Bank>() ;
	Lock lock=new ReentrantLock();
	Condition condition=lock.newCondition();

	private void initializedAcc() {
		map.put(1,new Bank(1,123,"A1"));
		map.put(2,new Bank(2,400,"A2"));
		map.put(3,new Bank(3,300,"A3"));
		map.put(4,new Bank(4,200,"A4"));
	}
	private int getAmount(int id) {
		lock.lock();
		try{
		Bank b=map.get(id);
		return b.getAmount();
		}
		finally{
			lock.unlock();
		}

	}
	
	private void transferMoneyTo(int from,int to,int amount) {
		lock.lock();
		try{
			Bank b=map.get(from);
			Bank b1=map.get(to);

			int fromAmount=getAmount(from);
			int toAmount=getAmount(to);
			while(fromAmount<amount){
				try {
					condition.await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			b.setAmount(fromAmount-amount);
			System.out.println(b.getAmount());
			b1.setAmount(toAmount+amount);
			System.out.println(b1.getAmount());
		}
		finally{
			lock.unlock();
		}
	}	
	public static void main(String[] args) {
		
		TransferMoney money=new TransferMoney();
		money.initializedAcc();

		Thread t1=new Thread(()->money.transferMoneyTo(1, 2, 2));
		Thread t2=new Thread(()->money.transferMoneyTo(1, 2, 2));
		t1.start();
		t2.start();
	}
}
