package com.test.superClass;

import com.thread.criticalSession.Pair;


class Foo {
	public int a;
	public Foo() {
		a = 3;
	}
	public void addFive() {
		a += 5;
	}
	public int getVal() {
		return a;
	}
}

public class Bar extends Foo {
	public int a;
	public Bar() {
		a = 8;
	}
	public void addFive() {
		this.a += 5;
	}
	public int getVal() {
		return a;
	}
	public static void main(String[] args) throws ClassNotFoundException {
		Foo foo = new Bar();
		foo.addFive();
		System.out.println("Value: " + foo.a);
		System.out.println("Value: " + foo.getVal());
		Class<Pair> pair = (Class<Pair>) Bar.class.getClassLoader().loadClass("com.thread.criticalSession.Pair");
	}

}
