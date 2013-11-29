package com.thread.fork_join;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
/**
 * 快速排序
 * @author 1207264
 *
 */
public class TestSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 int SIZE = 5000000;
		 calcTime("threadStart",SIZE);
		 calcTime("nomalStart",SIZE);
		 calcTime("arithmetic",SIZE);
	}
	
	
	public static void calcTime(String method,int SIZE){
		long s = System.currentTimeMillis();
		TestSort t = new TestSort();
		try {
			Method m = t.getClass().getMethod(method,Integer.class );
			m.invoke(t, SIZE);
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		long e = System.currentTimeMillis();
		System.out.println(method+":"+(e-s));
	}
	public void threadStart(Integer SIZE){
		ForkJoinPool forkJoinPool = new ForkJoinPool();  
	    Random rnd = new Random();  
	    long[] array = new long[SIZE];  
	    for (int i = 0; i < SIZE; i++) {  
	        array[i] = rnd.nextInt();  
	    }  
	    forkJoinPool.submit(new SortTask(array));  
	  
	    forkJoinPool.shutdown();  
	    try {
			forkJoinPool.awaitTermination(1, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}  
	  
	    for (int i = 1; i < SIZE; i++) {
	    	if(array[i - 1] > array[i]){
	    		System.out.println("................................");  
	    		System.exit(0);
	    	}
	    }  
//	    for(int i = 1 ;i<= array.length ;i ++){
//	    	System.out.print((i)+":"+array[i-1]+"\t");
//	    	if(i%10 ==0){
//	    		System.out.println();
//	    	}
//	    }
	    System.out.println();
	}
	public void nomalStart(Integer SIZE){
		Random rnd = new Random();  
	    long[] array = new long[SIZE];  
	    for (int i = 0; i < SIZE; i++) {  
	        array[i] = rnd.nextInt();  
	    }  
	    Arrays.sort(array);  
//	    SortTask s = new SortTask(array);
//	    s.compute(array, 0, array.length-1);
	}
	public void arithmetic(Integer SIZE){
		Random rnd = new Random();  
		long[] array = new long[SIZE];  
		for (int i = 0; i < SIZE; i++) {  
			array[i] = rnd.nextInt();  
		}  
//	    Arrays.sort(array);  
		SortTask s = new SortTask(array);
		s.compute(array, 0, array.length-1);
	}
}
