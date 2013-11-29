package com.thread.fork_join;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;

public class Test {

	public static void main(String[] args) throws Exception{  
		long s = System.currentTimeMillis();
		long e = System.currentTimeMillis();
		ForkJoinPool forkJoinPool = new ForkJoinPool();  
	    Future<Integer> result = forkJoinPool.submit(new Calculator(0, 1000000));  
	  
	    System.out.println(e-s+"!");
	    System.out.println(new Integer(49995000)+"."+ result.get());  
	}  
}
