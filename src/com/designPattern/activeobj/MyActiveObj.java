package com.designPattern.activeobj;



public class MyActiveObj extends Thread{
	MyQueue _queue;
	public MyActiveObj(){
		_queue = new MyQueue();
		start();
	}
	public void enqueue(Service mr) {
        _queue.enqueue(mr);
    }
	public void run(){
		while(true){
			Service mr = _queue.dequeue();
			mr.sayHello();
		}
	}
}
