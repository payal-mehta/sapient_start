package org.payal.work;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class SortArrayPrblem2 {

	public static void main(String[] args) {

		printSecondHeightest();
		System.out.print("\n\t-----------------------\t\n");
		
	}

	private static void printSecondHeightest () {
		int[] array = getArray();
		System.out.println(getNthHeightest (array, 2));
	}

	public static int getNthHeightest (int[] array, int n) {
		
		Queue<Integer> priorityQueue = getPriorityQueue ();
		int length = array.length;

		for(int index = 0; index < length; ++index) {
			priorityQueue.add(array[index]);
		}
		int v = Integer.MIN_VALUE;
		for (int i = 0; i < n; ++i) {
			v =  priorityQueue.remove();
		}
		return v;
	}

	private static int[] getArray() {
		return new int[] {
				9, 5, 6, 3, 7, 11, 4, 1, 2
		};
	}

	private static Queue<Integer> getPriorityQueue () {
		return new PriorityQueue<Integer>(new Comparator<Integer>() {
			public int compare(Integer x, Integer y) {
				return y - x;
			}
		});
	}
}
