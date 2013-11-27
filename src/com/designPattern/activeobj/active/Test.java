package com.designPattern.activeobj.active;

import com.designPattern.activeobj.Client;
import com.designPattern.activeobj.Service;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	       
       /**
        * 并发逻辑增加后
        */
		Service s = new  ServiceProxy();
 	    Client c = new Client(s);
        c.requestService();
	}

}
