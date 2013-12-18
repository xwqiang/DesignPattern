package com.test.ref;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
	static Map<Integer,String> map = new HashMap<Integer,String>();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		for(int i = 0 ;i<1000000;i++){
			map.put(i, "dj");
		}
		
	}
	public static String get(int i){
		if(map.get(i))
	}

}
