package com.multi.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadMurgeSort {
	ExecutorService executorService=Executors.newCachedThreadPool();
public static void main(String[] args) {
	
	MultiThreadMurgeSort murgeSort=new MultiThreadMurgeSort();
	int[] arr={2,3,1,4,5,7,8,9};
	murgeSort.executorService.execute(new Runnable() {
		
		@Override
		public void run() {
			
			murgeSort.divide(arr, 0, arr.length-1);
			murgeSort.print(arr);
			System.out.println("done");

		}
	});
	//murgeSort.divide(arr, 0, arr.length-1);
	
	}
	void print(int[] arr){
		int i=0;
		while(i++<arr.length){
			System.out.print(i+" ");
		}

	}
	private void divide(int[] arr ,int s,int e ) {
		System.out.println("in divide "+Thread.currentThread().getName()+" s:"+s+" e:"+e);
		if(s<e){
			CountDownLatch latch=new CountDownLatch(2);
			int m=s+((e-s)/2);
			executorService.execute(new Runnable() {
				
				@Override
				public void run() {
					divide(arr,s,m);
					latch.countDown();
				}
			});
			executorService.execute(new Runnable() {
				
				@Override
				public void run() {
					divide(arr,m+1,e);
					latch.countDown();
				}
			});
			try {
	            latch.await();
	        } catch (InterruptedException ex) {
	            // TODO Auto-generated catch block
	            ex.printStackTrace();
	        }
			merge(arr,s,m,e);
		}
	}

	private void merge(int[] arr, int s, int m, int e) {
		System.out.println("in merge "+Thread.currentThread().getName());

		int s1=m-s+1;
		int s2=e-m;
		int[] tem1=new int[s1];
		int[] tem2=new int[s2];
		int i=0;
		int j=0;
		for(i=s;i<=m;i++){
			tem1[j++]=arr[i];
		}
		 j=0;
		for(i=m+1;i<=e;i++){
			tem2[j++]=arr[i];
		}
		i=0;j=0;int k=s;
		while(i<tem1.length && j<tem2.length){
			if(tem1[i]<tem2[j]){
				arr[k++]=tem1[i++];
			}
			else{
				arr[k++]=tem2[j++];
			}
		}
		while(i<tem1.length-1){
			arr[k++]=tem1[i++];
		}
		while(i<tem2.length-1){
			arr[k++]=tem2[i++];
		}
	}
}
