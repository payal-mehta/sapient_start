package org.test.project1;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void divide(int[] arr, int start, int end){
		if(start<end){
			int middle= (start+end)/2;
			divide(arr,start,middle);
			divide(arr,middle+1,end);
			merge(arr,start,middle,end);
		}
		
	}
    private static void merge(int[] arr, int start, int middle, int end) {
    	int firstSize=middle-start+1;
    	int secondSize=end-middle;

    	int[] firstArray=new int[firstSize];
    	int[] secondArray=new int[secondSize];
    	int firstArrayCounter=0;
    	int secondArrayCounter=0;
    	int size=start;
    	for(int i=0;i<firstSize;i++){
    		firstArray[i]=arr[i+start];
    	}
    	for(int i=0;i<secondSize;i++){
    		secondArray[i]=arr[middle+1+i];
    	}
    	for(; firstArrayCounter<firstSize && secondArrayCounter<secondSize;size++){
    		if(firstArray[firstArrayCounter]<=secondArray[secondArrayCounter]){
    			arr[size]=firstArray[firstArrayCounter];
    			firstArrayCounter++;
    		}
    		else{
    			arr[size]=secondArray[secondArrayCounter];
    			secondArrayCounter++;
    		}
    	}
    	
    	/* Copy remaining elements of L[] if any */
        while (firstArrayCounter < firstSize)
        {
            arr[size++] = firstArray[firstArrayCounter++];
        }
 
        /* Copy remaining elements of R[] if any */
        while (secondArrayCounter < secondSize)
        {
        	arr[size++] = secondArray[secondArrayCounter++];
        }
    	
	}
	public static void main( String[] args )
    {
        int arr[]= {11,5,0,55,3,66};
        System.out.println(arr);
        long startTime = System.nanoTime();
        divide(arr, 0, arr.length-1);
        long endTime = System.nanoTime();

        long duration = (endTime - startTime);
       
        printArray(arr);
        System.out.println(duration);
    }
	 /* A utility function to print array of size n */
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
