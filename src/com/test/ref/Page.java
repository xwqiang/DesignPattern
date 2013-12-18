package com.test.ref;

import java.util.ArrayList;
import java.util.List;

public class Page implements IKeyValue{
	int index;
	List<String> list ;
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public List<String> getList() {
		return list;
	}
	public void setList(List<String> list) {
		this.list = list;
	}
	public String toString(){
		return index+":"+list.toString();
	}
	public void add(String s){
		if(list==null){
			list = new ArrayList<String>();
		}
		list.add(s);
	}
	public String getKey() {
		return this.toString();
	}
	
}
