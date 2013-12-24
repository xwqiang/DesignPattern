package com.test.string;

public class StringTest {

	public static void main(String[] args) {
		String s = "+0432423430";
		StringBuilder sb = new StringBuilder(s);
		long time = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			// s += ""+i;//306
			// s = s.concat(i+"");//150
			sb.append(i + "");// 6
			sb.append(Integer.toString(i));// 3
		}
		System.out.println(System.currentTimeMillis() - time);
		System.out.println("s-->" + s);
	}
}
