package com.system.path;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;



public class TestPath {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String path = System.getProperty("user.home");
		String path1 = System.getProperty("user.dir");
		System.out.println(path);
		System.out.println(path1);
		List<String> list = new ArrayList<String>();
		list.add("abc");
		list.add("edd");
		String s = StringUtils.join(list,',');
		System.out.println(s);
		String[] ss =new String[]{"aa","bb"};
		String s1 = StringUtils.join(ss,',');
		System.out.println(s1);

	}

}
