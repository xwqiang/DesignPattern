package com.designPattern.oberver_custom;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyObee obee = new MyObee();
		obee.addListener(new MyOber());
		obee.doSomething();
	}
}
