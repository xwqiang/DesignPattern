package com.designPattern.oberver2;

import java.util.Observable;
import java.util.Observer;

public class MyObserver implements Observer {
	public MyObserver(Observable obj){
		obj.addObserver(this);
	}
	public void update(Observable arg0, Object arg1) {
		if(arg0 instanceof MyObservable){
			Model m = (Model)arg1;
			System.out.println(m.getSs());
			m.setSs("fjdslk");
			System.out.println("MyObserver....");
		}

	}

}
