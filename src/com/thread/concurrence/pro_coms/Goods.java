package com.thread.concurrence.pro_coms;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Goods {
	private List<String> list;
	private int index ;
	public Goods(){
		list = new ArrayList<String>();
		this.index = -1;
	}
	public synchronized String getNext() throws InterruptedException{
		while(list.size()<=0){
			wait();
		}
//		TimeUnit.MILLISECONDS.sleep(100);
		String s =  list.get(index);
		list.remove(index);
		index--;
		return s;
		
	}
	public synchronized void add(String item){
		list.add(item);
		index++;
		try {
			TimeUnit.MILLISECONDS.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(list.size()+".........................");
		notify();
	}
}
