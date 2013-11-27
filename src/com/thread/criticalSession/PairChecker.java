package com.thread.criticalSession;

class PairChecker implements Runnable{
	private PairManager pm;
	public PairChecker(PairManager pm){
		this.pm = pm;
	}
	public void run(){
		while(true){
			pm.checkCounter.incrementAndGet();
			pm.getPair().checkStat();
			System.out.println(Thread.currentThread().getId()+":"+pm.getPair()+"...checked");
		}
	}
}