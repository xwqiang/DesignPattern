package com.designPattern.activeobj.active;

import java.util.Stack;

public class ActiveQueue {
	private Stack<MethodRequest> _queue;
	private final static int QUEUE_SIZE = 20;
	public ActiveQueue(){
		this._queue = new Stack<MethodRequest>();
	}
	public synchronized  void enqueue(MethodRequest mr){
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
	
	public synchronized MethodRequest dequeue() {
        MethodRequest mr;
        while(_queue.empty()) {
            try {
                wait();
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        mr = (MethodRequest)_queue.pop();
        notifyAll();
        return mr;
    }    
}
