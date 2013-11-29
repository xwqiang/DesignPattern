package com.thread.fork_join;


public class Calculator1 {
    private int start;  
    private int end; 
    public Calculator1(int start, int end) {  
        this.start = start;  
        this.end = end;  
    }  
	protected Integer compute() {
	int sum = 0;
	for(int i = start ; i < end ;i++){
		sum += i;
	}
	return sum;
	}
	public static void main(String[] a){
		long s = System.currentTimeMillis();
		Calculator1 c = new Calculator1(0, 1000000);
		int i = c.compute();
		long e = System.currentTimeMillis();
		System.out.println(e-s);
		System.out.println(i);
	}
}
