package com.thread.concurrence.pro_coms;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Shop{
	public static void main(String[] args){
		Goods g = new Goods();
		Comsumer c = new Comsumer(g);
		Producer p = new Producer(g);
		ExecutorService e = Executors.newCachedThreadPool();
		e.execute(c);
		e.execute(p);
		e.shutdown();
	}
}
