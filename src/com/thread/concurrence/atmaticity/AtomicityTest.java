package com.thread.concurrence.atmaticity;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AtomicityTest implements Runnable {
	private int i= 0 ;
	private int getValue(){//evenIncrement() is locked but thread can get value at any time.
		return i;
	}
	private synchronized int poll(){
		return i;
	}
	private synchronized void evenIncrement(){
		i++;
		i++;
	}
	public void run() {
		while(true){
			evenIncrement();
		}
	}
	public static void main(String[] a){
		ExecutorService e = Executors.newCachedThreadPool();
		AtomicityTest at = new AtomicityTest();
		e.execute(at);
		while(true){
			int val = at.getValue();
			if(val % 2 != 0){
				System.out.println(val);
				System.exit(0);
			}else{
				System.out.println(val);
			}
		}
	}
}
