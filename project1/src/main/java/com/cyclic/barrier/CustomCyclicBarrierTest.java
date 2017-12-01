package com.cyclic.barrier;


public class CustomCyclicBarrierTest {
public static void main(String[] args) {
	CustomCyclicBarrier barrier=new CustomCyclicBarrier(3,new CustomCyclicBarrierEvent());
	Thread t1= new Thread(new CustomTask(barrier));
	Thread t2= new Thread(new CustomTask(barrier));
	Thread t3= new Thread(new CustomTask(barrier));
t1.start();
t2.start();
t3.start();
Thread t4= new Thread(new CustomTask(barrier));
Thread t5= new Thread(new CustomTask(barrier));
Thread t6= new Thread(new CustomTask(barrier));

t4.start();
t5.start();
t6.start();
}
}
