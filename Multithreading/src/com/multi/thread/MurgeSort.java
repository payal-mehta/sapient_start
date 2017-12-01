package com.multi.thread;

public class MurgeSort {
public static void main(String[] args) {
	MurgeSort murgeSort=new MurgeSort();
	int[] arr={2,3,1,4,5,6};
	murgeSort.divide(arr, 0, arr.length-1);
	murgeSort.print(arr);;

	}
	void print(int[] arr){
		int i=0;
		while(i++<arr.length){
			System.out.print(i+" ");
		}

	}
	private void divide(int[] arr ,int s,int e ) {
		if(s<e){
			int m=s+((e-s)/2);
			divide(arr,s,m);
			divide(arr,m+1,e);
			merge(arr,s,m,e);
		}
	}

	private void merge(int[] arr, int s, int m, int e) {
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
		while(i<=tem1.length-1){
			arr[k++]=tem1[i++];
		}
		while(j<=tem2.length-1){
			arr[k++]=tem2[j++];
		}
	}
}
