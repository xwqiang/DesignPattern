package com.thread.concurrence;

public class EvenGenerator extends IntGenerator {
	private int currentEvenValue= 0;
	@Override
	public int next() {
		++currentEvenValue;// danger code here
		Thread.yield();
		++currentEvenValue;
		return currentEvenValue;
	}
	

}
