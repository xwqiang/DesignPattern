package com.thread.criticalSession;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CriticalSession {

	static void testApproaches(PairManager pman1,PairManager pman2){
		ExecutorService exec = Executors.newCachedThreadPool();
		PairManipulator pm1 = new PairManipulator(pman1),
						pm2 = new PairManipulator(pman2);
		PairChecker pcheck1 = new PairChecker(pman1),
					pcheck2 = new PairChecker(pman2);
		exec.execute(pm1);
		exec.execute(pm2);
		exec.execute(pcheck1);
		exec.execute(pcheck2);
		try {
			TimeUnit.MILLISECONDS.sleep(2500);
		} catch (InterruptedException e) {
			System.out.println("sleep interrupted");
			e.printStackTrace();
		}
		System.out.println("pm1: "+pm1+"\npm2: "+pm2);
		System.exit(0);
	}
	
	public static void main(String[] args) {
		PairManager pman1 = new PairManager1();
		PairManager pman2 = new PairManager2();
		testApproaches(pman1,pman2);
		
	}

}
