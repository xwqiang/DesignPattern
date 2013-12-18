package com.test.ref;

import java.util.ArrayList;
import java.util.List;

public class ParaTest {
	protected int i = 0;
	protected A a ;
	List<A> list = new ArrayList<A>();
	public ParaTest(){
		a = new A();
	}
	public void addA(A a){
		list.add(a);
	}
	public void change(int i){
		i = 5;
	}
	public void changeA(ParaTest p){
		p.a.setT(100);
	}
	public void changeP(ParaTest p){
//		ParaTest tmp = new ParaTest();
//		tmp.i = 9;
//		p = tmp;//no
		p.i = 912;//注释1 yes
		p.a = new A(){{setT(333);}};//no
		p.a.setT(444);//yes
		p.a.t=555;//yes
		
		A _a = new A(){{setT(888);}};
		p.list.add(new A(){{setT(777);}});
		p.list.add(_a);
		_a.setT(999);
		//..........
	}
	public void add(int i ){
		i+= 10;
	}
	public void add(ParaTest p){
		p.i+=20;
	}
	public static void main(String[] a){
		ParaTest p = new ParaTest();
		
		
//		p.change(2);
//		System.out.println(p.i);//0
		
		p.changeA(p);
		p.changeP(p);
		System.out.println(p.a.toString());//0
		System.out.println(p.i);//0
		System.out.println(p.list);//0
		
//		p.add(p.i);	
//		System.out.println(p.i);//0
		
//		p.add(p);
//		System.out.println(p.i);//20
	}
}
