package com.designPattern.oberver_custom;


public class MyOber implements IOber {
	public void action(Obee arg0, Object arg1) {
		System.out.println(arg0);
		System.out.println(arg1);
	}

}
