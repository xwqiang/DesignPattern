package com.thread.concurrence;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EvenChecker implements Runnable {
	private IntGenerator generator;
	private final int id;
	public EvenChecker(IntGenerator g,int ident){
		this.generator = g;
		id = ident;
	}
	public void run() {
		while(!generator.isCanceled()){
			int val = generator.next();
			if( val % 2 != 0 ){
				System.out.println(val+" id:"+id+" not even");
				generator.cancel();
			}
		}
	}
	public static void test(IntGenerator g ,int count){
		ExecutorService e = Executors.newCachedThreadPool();
		for(int i = 0;i<count;i++){
			e.execute(new EvenChecker(g,i));
		}
		e.shutdown();
	}
}
