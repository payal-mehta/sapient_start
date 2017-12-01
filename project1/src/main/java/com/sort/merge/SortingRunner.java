package com.sort.merge;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;


    public class SortingRunner {

        public static void main(String[] args) throws InterruptedException, ExecutionException {
            Integer[] initialOrders = new Integer[Short.MAX_VALUE*32];
            Random random = new Random();
            for (int i =0 ;i<Short.MAX_VALUE*32;i++){
                initialOrders[i]=Integer.valueOf(random.nextInt(Integer.MAX_VALUE));
            }
            MergeSortor<Integer> sortor = new MergeSortor<Integer>(
                    Arrays.asList(initialOrders), new IntegerComparator());

            ForkJoinPool pool = new ForkJoinPool();
            MergeTask<Integer> task = new MergeTask<Integer>(Arrays.asList(initialOrders), new IntegerComparator());


            long start = System.currentTimeMillis();
            sortor.getSortedResult();
            long end =  System.currentTimeMillis();
            System.out.println(end - start );


            start = System.currentTimeMillis();
            pool.invoke(task);
            end =  System.currentTimeMillis();
            System.out.println(end - start );
        }
        static public class IntegerComparator implements Comparator<Integer> {

            @Override
            public int compare(Integer o1, Integer o2) {
                int f = o1.hashCode(); // Auto-unboxing
                int s = o2.hashCode(); // Auto-unboxing
                return f < s ? -1 : (f == s ? 0 : 1); // No unboxing
            }
        }
    }