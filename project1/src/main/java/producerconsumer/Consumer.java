package producerconsumer;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{
	private final BlockingQueue sharedQueue;
	private int maxSize;
	private String name;
	public Consumer (BlockingQueue sharedQueue) {
        this.sharedQueue = sharedQueue;
    }
  
    @Override
    public void run() {
        while(true){
            try {
                System.out.println("Consumed: "+ sharedQueue.take());
            } catch (InterruptedException ex) {
            	System.out.println(Consumer.class.getName());            }
        }
    }


	

}
