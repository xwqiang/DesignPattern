package com.thread.concurrence;

import com.designPattern.oberver2.Model;

public class Test {
	public static String f(){
		String s ="";
		try {
			 s ="aa";
			 return s;
		} finally{
			s ="bb";
		}
//		return s;
	}
	public  static void main(String[] a){
		EvenChecker.test(new EvenGenerator(), 10);
//		EvenChecker.test(new EvenGenerator(), 10);
//		EvenChecker.test(new MutexEvenGenerator(), 10);
		
	}
}
