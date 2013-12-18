package com.test.ref;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class GenTest<T> {
	List<T> list = new ArrayList<T>();
	Queue<T> queue = new ArrayBlockingQueue<T>(10);
	public T get(){
		for(T t : list){
			System.out.println("list->"+t);
		}
		for(T t: queue){
			System.out.println("queue-->"+t);
		}
		return null;
	}
	public void add(T t){
		list.add(t);
		queue.add(t);
	}
	public static void main(String[] a){
		GenTest<Page> test = new GenTest<Page>();
		test.add(new Page(){{add("aa");}});
		test.get();
		
		GenTest<String> test1 = new GenTest<String>();
		test1.add("abc");
		test1.get();
		
		
	}
}
