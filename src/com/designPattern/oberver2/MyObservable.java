package com.designPattern.oberver2;

import java.util.Observable;

public class MyObservable extends Observable {
	Model m = new Model();
	public void doSomething(){
		super.setChanged();
		m.setSs("aa");
		super.notifyObservers(m);
	}
}
