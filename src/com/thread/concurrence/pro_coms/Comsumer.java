package com.thread.concurrence.pro_coms;



public class Comsumer implements Runnable{
	private Goods goods;
	public Comsumer(Goods g){
		this.goods = g;
	}
	public void run(){
		while(true){
			try {
				String s = goods.getNext();
				System.out.println("--comsuming items l"+ s);
//				TimeUnit.MILLISECONDS.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
