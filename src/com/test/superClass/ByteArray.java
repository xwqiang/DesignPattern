package com.test.superClass;

import java.util.ArrayList;
import java.util.List;

public class ByteArray {
	public static void main(String[]  da){
		list();
	}
	public static void list(){
		List<String> list = new ArrayList<String>();
		String i = "jfds";
		list.add(i);
		System.out.println(list);
		i = "a";
		System.out.println(list);
		
	}
	public void arr(){
		int a = 1;
		int b = 2;
		int c = 3;
		int[] ch = new int[4];
		ch[0] = 10;
		ch[1] = a;
		ch[2] = b;
		ch[3] = c;
		a = 343;
		for(int i: ch){
			System.out.print(i+"  ");
		}
	}
}
