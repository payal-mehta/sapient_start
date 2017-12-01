package org.test.project1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class NLargestElement {
	public static Integer findKthLargest(int[] nums, int k) {
		//List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
		Integer v=null;
		PriorityQueue<Integer>  priorityQueue=new PriorityQueue<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
		});
		for(int value :nums) {
			priorityQueue.add(value);
		}
		for (int i = 0; i < k; ++i) {
			v =  priorityQueue.remove();
		}
		return v;

	}
	/*public static long findKthLargestElement(int[] input, int k) {
	    if(k < 1 || k > input.length) {
	        throw new IllegalArgumentException("Invalid k, should be between 1 and array length");
	    }
	    PriorityQueue<Integer>  priorityQueue=new PriorityQueue<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
		});
		for(int value :input) {
			priorityQueue.add(value);
		}
		//priorityQueue.stream()
	    return Arrays.stream(input)
	            .sorted()
	            .skip(input.length - k)   // jump to kth element
	            .findFirst()              // retrieve element
	            .getAsInt();             // no need for optional long, just return value
	}*/
	public static void main(String[] args) {
		int[] array={12,33,66,77,1,3,4};
		long startTime = System.nanoTime();
		System.out.println(findKthLargest(array, 5));
		long endTime = System.nanoTime();
		System.out.println("Prioriy queue :"+(endTime-startTime));
		 startTime = System.nanoTime();
		//System.out.println(findKthLargestElement(array, 5));
		 endTime = System.nanoTime();
		System.out.println("java 8 queue :"+(endTime-startTime));

	}
}
