package com.test.ref;

import java.util.ArrayList;

public class TestPage {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Page p = new Page();
//		String s = "aa";
//		p.setList(new ArrayList<String>());
//		p.getList().add(s);
//		p.getList().add("bb");
		p.add("cc");
		p.add("dd");
		System.out.println(p);
	}
}
