package com.thread.concurrence.atmaticity;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadTest implements Runnable {
	private SerialNumberGenerator g ;
	ThreadTest(SerialNumberGenerator g){
		this.g = g;
	}
	public void run() {
		while(true){
			int val = g.nextSerialNumber();
//			if(val!=g.getnum()){
				System.out.println(val+".."+g.getnum());
//				System.exit(0);
//			}
		}
	}
	public static void main(String[] a ){
		SerialNumberGenerator g = new SerialNumberGenerator();
		ExecutorService e = Executors.newCachedThreadPool();
		for(int i = 0; i<100 ;i++){
			e.execute(new ThreadTest(g));
		}
		e.shutdown();
	}
}
