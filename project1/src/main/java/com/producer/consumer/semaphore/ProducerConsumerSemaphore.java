package com.producer.consumer.semaphore;


public class ProducerConsumerSemaphore {
public static void main(String[] args) {
	Queue queue=new Queue(1000);
	new Producer(queue);
	new Consumer(queue);
}
}
