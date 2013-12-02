package com.thread.concurrence.pro_coms;



public class Producer implements Runnable{
	private Goods goods;
	public Producer(Goods g){
		this.goods = g;
	}
	public void run(){
		while(true){
			goods.add("item:"+Math.random()*100);
			System.out.println("++producing items");
//			try {
//				TimeUnit.MILLISECONDS.sleep(500);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
		}
	}
}
