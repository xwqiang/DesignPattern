package com.thread.testvolatile;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class TestVolatile implements Runnable{
	boolean isRunning;
	AtomicInteger num ;
	public TestVolatile(boolean isRunning,AtomicInteger num){
		this.isRunning = isRunning;
		this.num = num;
		isRunning = true;
	}
	public void run(){
		synchronized(this){
		while(isRunning){
				System.out.println(num.addAndGet(1));
				if(num.get()==2000){
					isRunning = false;
				}
//				Thread.yield();
//				try {
//					TimeUnit.MILLISECONDS.sleep(5);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
			}
		}
	}
	public static void main(String[] a){
		TestVolatile t = new TestVolatile(new Boolean(true),new AtomicInteger(0));
		ExecutorService e = Executors.newCachedThreadPool();
		for(int i = 0;i<100;i++){
			e.execute(t);
		}
		e.shutdown();
	}
}
