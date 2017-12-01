package com.custom.thread.pool;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;

public class FutureTest {
public static void main(String[] args) throws InterruptedException {
	final ThreadFactory factory = new ThreadFactory() {
		 
	    @Override
	    public Thread newThread(Runnable target) {
	        final Thread thread = new Thread(target);
	       // log.debug("Creating new worker thread");
	        thread.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
	            @Override
	            public void uncaughtException(Thread t, Throwable e) {
	            	System.out.println("Uncaught Exception "+ e);
	            }
	 
	        });
	        return thread;
	    }
	 
	};
	ExecutorService executorService=Executors.newFixedThreadPool(2, factory);
	// executorService=Executors.newFixedThreadPool(2, factory);

	executorService.execute(new Task());
	
	Callable call = new Callable<Integer>() {

		@Override
		public Integer call() throws Exception {
			int i=0;
			while(i<100){
				
				i++;
				throw new NullPointerException();
				}
			return i;
		}
	};
	
	//Task t=new Task();
	
	
Future future=executorService.submit(call);
	try {
		System.out.println(future.get());
	} catch (ExecutionException e) {
    	System.out.println("Exception ");
		//e.printStackTrace();
	}
	//executorService.execute(t);*/
}
}
