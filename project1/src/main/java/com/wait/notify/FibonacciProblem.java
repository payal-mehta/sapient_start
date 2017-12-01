package com.wait.notify;

public class FibonacciProblem {
	static public int fibRec(int n){

		if(n==0){
			return 0;
		}
		else if(n==1){
			return 1;
		}
		else{
			return fibRec(n-1)+fibRec(n-2);
		}

	}
	
	public static int fibonacci(int n) {
	    int[] fib = new int[2]; 
	    fib[0] = 0; fib[1] = 1;
	    for (int i = 2; i <= n; ++i) {
	        fib[i % 2] = fib[0] + fib[1];
	    }
	    return fib[n % 2];
	}
	
	static public int fibSeriesDP(int n){
		int f[] = new int[n+1];
		f[0]=0;
		f[1]=1;

		for(int i=2;i<=n;i++){
			f[i] = f[i-1] + f[i-2]; 
		}
		return f[n];

	}
	public static void main(String[] args) {
		long startTime = System.nanoTime();
		System.out.println(fibRec(8));
		long endTime = System.nanoTime();
		
		System.out.println("recursive :"+(endTime-startTime));
		startTime = System.nanoTime();
		System.out.println(fibSeriesDP(8));
		endTime = System.nanoTime();
		System.out.println("DP "+(endTime-startTime));
		
		System.out.println("recursive :"+(endTime-startTime));
		startTime = System.nanoTime();
		System.out.println(fibonacci(8));
		endTime = System.nanoTime();
		System.out.println("DP effective "+(endTime-startTime));
	}

}
