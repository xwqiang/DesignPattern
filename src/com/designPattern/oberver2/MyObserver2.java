package com.designPattern.oberver2;

import java.util.Observable;
import java.util.Observer;

public class MyObserver2 implements Observer {
	public MyObserver2(Observable obj){
		obj.addObserver(this);
	}
	public void update(Observable arg0, Object arg1) {
		if(arg0 instanceof MyObservable){
			Model m = (Model)arg1;
			System.out.println(m.getSs());
			System.out.println("MyObserver2....");
		}

	}

}
