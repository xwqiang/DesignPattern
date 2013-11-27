package com.designPattern.activeobj;


public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		/**
		 * 并发逻辑增加前
		 */
//		 Service s = new ServiceImp();
//	     Client c = new Client(s);
//	     c.requestService();
	     
	     
	     MyProxy p = new MyProxy();
	     Client client = new Client(p);
	     client.requestService();
	}

}
