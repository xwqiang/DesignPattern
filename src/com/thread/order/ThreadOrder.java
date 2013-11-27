package com.thread.order;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadOrder {
	int num = 10;
	class Inner implements Runnable{
		int k = num;
		public void run() {
			for(int i = 0 ;i<k;i++){
				System.out.println(i);
			}
		}
	}
	public ThreadOrder(int num){
		Inner i = new Inner();
		Thread t =  new Thread(i);
		t.start();
		num = num+100;
		System.out.println("un");
	}
	public ThreadOrder(String s){
		Inner i = new Inner();
		Thread t =  new Thread(i);
		ExecutorService  e = Executors.newCachedThreadPool();
		e.execute(i);
		e.shutdown();
		System.out.println("....."); 
	}
	public static void main(String[] a){
//		ThreadOrder o = new ThreadOrder("d");
		ThreadOrder f = new ThreadOrder(12);
	}
}
