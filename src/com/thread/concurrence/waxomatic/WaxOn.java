package com.thread.concurrence.waxomatic;

import java.util.concurrent.TimeUnit;

public class WaxOn implements Runnable {
	private Car car;

	public WaxOn(Car c) {
		car = c;
	}

	public void run() {
		try {
			while (!Thread.interrupted()) {
				System.out.println("wax on!");
				TimeUnit.MILLISECONDS.sleep(200);
				car.waxed();
				car.waitForWaxing();
			}
		} catch (InterruptedException e) {
			System.out.println("exiting via interrupt");
			e.printStackTrace();
		}
		System.out.println("ending wax on task");
	}
}
