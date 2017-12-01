package com.custom.blocking.queue;

public interface CustomBlockingQueue<E> {
 void put(E item);
 E take();
}
