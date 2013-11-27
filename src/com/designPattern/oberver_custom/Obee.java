package com.designPattern.oberver_custom;

import java.util.ArrayList;
import java.util.List;

public class Obee {
	private List<IOber> list = new ArrayList<IOber>();
	public void addListener(IOber o){
		list.add(o);
	}
	public void notifyObserver(Object args){
		for(IOber o :list){
			o.action(this,args);
		}
	}
}
