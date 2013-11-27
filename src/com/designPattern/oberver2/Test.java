package com.designPattern.oberver2;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyObservable myObservable = new MyObservable();
		new MyObserver2(myObservable);
		new MyObserver(myObservable);
		myObservable.doSomething();
	}

}
