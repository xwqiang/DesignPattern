package com.thread.fork_join;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

public class Calculator extends RecursiveTask<Integer> {
	private static final long serialVersionUID = 1L;
	private static final int THRESHOLD = 100;  
    private int start;  
    private int end; 
    public Calculator(int start, int end) {  
        this.start = start;  
        this.end = end;  
    }  
	@Override
	protected Integer compute() {
		int sum = 0;
		if((end - start) < THRESHOLD){
			for(int i = start ; i < end ;i++){
				sum += i;
			}
		}else{
			int middle = (end + start)/2;
			Calculator left = new Calculator(start,middle);
			Calculator right = new Calculator(middle,end);
			left.fork();
			right.fork();
			sum = left.join() + right.join();
		}
		return sum;
	}
	
	

}
