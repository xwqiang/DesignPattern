package com.thread.concurrence.waxomatic;

public class Car {
	private boolean waxOn = false;
	public synchronized void buffed(){
		waxOn = false;
		notifyAll();
	}
	public synchronized void waxed(){
		waxOn = true;
		notifyAll();
	}
	public synchronized void waitForWaxing() throws InterruptedException{
		while(waxOn== false){
			wait();
		}
	}
}
