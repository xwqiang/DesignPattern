package com.designPattern.activeobj;

import java.util.Stack;


public class MyQueue {

	private Stack _queue;
	private final static int QUEUE_SIZE = 20;
	public MyQueue(){
		this._queue = new Stack();
	}
	public synchronized  void enqueue(Service mr){
		while(_queue.size()>QUEUE_SIZE){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		_queue.push(mr);
		notifyAll();
	}
	
	public synchronized Service dequeue() {
		Service mr;
        while(_queue.empty()) {
            try {
                wait();
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        mr = (Service)_queue.pop();
        notifyAll();
        return mr;
    }    

	

}
