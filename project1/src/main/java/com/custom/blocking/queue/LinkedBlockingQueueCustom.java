package com.custom.blocking.queue;

import java.util.LinkedList;
import java.util.List;

public class LinkedBlockingQueueCustom<E> implements CustomBlockingQueue<E>{
	  private List<E> queue;
      private int  maxSize ; //maximum number of elements queue can hold at a time.
 
      public LinkedBlockingQueueCustom(int maxSize){
     this.maxSize = maxSize;
     queue = new LinkedList<E>();
      }

	@Override
	public synchronized void   put(E item) {
		while(queue.size()==maxSize){
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		queue.add(item);
		this.notifyAll();
	}

	@Override
	public synchronized E   take() {
		E consumed = null;
		while(queue.isEmpty()){
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
			consumed=queue.remove(0);
			this.notifyAll();
		
		return consumed;
		
	}

	
	

}
