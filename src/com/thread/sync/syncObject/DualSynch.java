package com.thread.sync.syncObject;

public class DualSynch {
	private Object syncObject = new Object();
	public synchronized void f(){
//		for(int i  = 0 ;i<5;i++){
		while(true){
			System.out.println("f()");
			Thread.yield();
		}
	}
	public void g(){
		synchronized(syncObject){
//			for(int i = 0;i<5;i++){
			while(true){
				System.out.println("g()");
				Thread.yield();
			}
		}
	}
}
