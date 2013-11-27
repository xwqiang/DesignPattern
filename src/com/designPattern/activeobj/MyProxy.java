package com.designPattern.activeobj;

public class MyProxy implements Service{
	Service s ;
	MyActiveObj obj;
	public MyProxy(){
		s = new ServiceImp();
		obj = new MyActiveObj();
	}
	public void sayHello(){
		obj.enqueue(s);
	}
	
}
