package com.thread.criticalSession;

public class PairManager2 extends PairManager {

	@Override
	public synchronized void increment() {
		Pair temp;
		synchronized(this){
			p.incrementX();
			p.incrementY();
			temp = getPair();
		}
		store(temp);
	}

}
