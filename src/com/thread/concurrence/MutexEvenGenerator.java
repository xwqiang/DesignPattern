package com.thread.concurrence;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MutexEvenGenerator extends IntGenerator {
	private int currentEvenValue= 0;
	private Lock lock = new ReentrantLock();
	@Override
	public int next() {
		lock.lock();
		try {
			++currentEvenValue;// danger code here
			Thread.yield();
			++currentEvenValue;
			return currentEvenValue;
		} finally{
			lock.unlock();
		}
//		return currentEvenValue;//return 也非原子操作
	}
	

}
