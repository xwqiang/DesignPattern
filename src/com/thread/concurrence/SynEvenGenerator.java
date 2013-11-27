package com.thread.concurrence;

public class SynEvenGenerator extends IntGenerator {
	private int currentEvenValue= 0;
	@Override
	public synchronized int next() {
		++currentEvenValue;// danger code here
		Thread.yield();
		++currentEvenValue;
		return currentEvenValue;
	}
	

}
