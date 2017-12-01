package com.custom.thread.pool;

public class ThreadPoolExceutor {
	public static void main(String[] args) {
		ThreadPool threadPool=new ThreadPool(5);
		for(int i=0;i<10;i++){
			threadPool.submit(new Task());
		}
		threadPool.shutDown();
		for(int i=0;i<10;i++){
			threadPool.submit(new Task());
		}
	}
}
