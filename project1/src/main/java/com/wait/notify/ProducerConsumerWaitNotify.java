package com.wait.notify;

import java.util.LinkedList;
import java.util.Queue;

import com.custom.thread.pool.Consumer;

public class ProducerConsumerWaitNotify {
public static void main(String[] args) {
	Queue<Integer> sharedQueue=new LinkedList<>();
	final int maxSize=10;
	Thread producer=new Thread(new Producer(sharedQueue,maxSize,"Producer"));
	Thread consumer=new Thread(new Consumer(sharedQueue,"Cosumer"));
	producer.start();
	consumer.start();
}
}
