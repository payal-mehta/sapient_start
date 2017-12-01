package com.custom.blocking.queue;


public class ProducerConsumerCustomBlockingQueue {
public static void main(String[] args) {
	CustomBlockingQueue<Integer> sharedQueue=new LinkedBlockingQueueCustom<Integer>(10);
	Thread producer=new Thread(new Producer(sharedQueue,"Producer"));
	Thread consumer=new Thread(new Consumer(sharedQueue,"Cosumer"));
	producer.start();
	consumer.start();
}
}
