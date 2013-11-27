package com.thread.concurrence.waxomatic;

import java.util.concurrent.TimeUnit;

public class WaxOff implements Runnable {
	private Car car ;
	public WaxOff(Car c){
		car = c;
	}
	public void run() {
		try {
			while(!Thread.interrupted()){
				car.waitForWaxing();
				System.out.println("wax off!");
				TimeUnit.MILLISECONDS.sleep(200);
				car.buffed();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
