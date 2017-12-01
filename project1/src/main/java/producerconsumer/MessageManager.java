 package producerconsumer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;


public class MessageManager {
	static AtomicInteger totalConsumed;
	static AtomicInteger totalProduced;
	final int CAPACITY = 30;
	LinkedList<Message> list = new LinkedList<>();
	AtomicReference<LinkedList<Message>> messageList = new AtomicReference<LinkedList<Message>>(
			list);
	Object producerLock = new Object();
	Object consumerLock = new Object();

	public List<Thread> getProducers() {
		return producers;
	}

	public List<Thread> getConsumers() {
		return consumers;
	}

	List<Thread> producers = new ArrayList<>();
	List<Thread> consumers = new ArrayList<>();

	public void consumeMessage() throws InterruptedException {
		while (true) {
			// System.out.println("consume attempt");
			synchronized (consumerLock) {
				// if (messageList.get().size() != 0) {
				// continue;
				// consumerLock.wait();
				System.out.println("current size " + messageList.get().size());
				Message msg = messageList.get().pollFirst();
				System.out.println("A message consumed and current size "
						+ messageList.get().size());
				if (msg != null)
					msg.execute();
				// consumerLock.notifyAll();
			}
		}
		// }
	}

	public void produceMessage() throws InterruptedException {
		while (true) {
			// System.out.println("produce attempt");
			synchronized (producerLock) {
				if (messageList.get().size() != CAPACITY) {
					// continue;
					// producerLock.wait();
					Message msg = new Message("Message ");
					System.out.println("A message produced --> "
							+ Thread.currentThread().getName()
							+ " siz of queue " + messageList.get().size());
					messageList.get().add(msg);
					// producerLock.notifyAll();
				}
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		MessageManager manager = new MessageManager();
		for (int i = 1; i <= 10; i++) {
			manager.createConsumers(manager, i);
			manager.createProducers(manager, i);
		}

		for (Thread producer : manager.producers) {
			producer.start();
		}

		for (Thread consumer : manager.consumers) {
			consumer.start();
		}

		for (Thread producer : manager.producers) {
			producer.join();
		}

		for (Thread consumer : manager.consumers) {
			consumer.join();
		}

	}

	private void createProducers(MessageManager manager, int number) {
		Thread th = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					manager.produceMessage();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "Producer" + number);
		manager.getProducers().add(th);
	}

	private void createConsumers(MessageManager manager, int number) {
		Thread th = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					manager.consumeMessage();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "Consumer " + number);
		manager.getConsumers().add(th);
	}

}
