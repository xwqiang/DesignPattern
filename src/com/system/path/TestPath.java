package com.system.path;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.lang.StringUtils;



public class TestPath {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String path = System.getProperty("user.home");
		String path1 = System.getProperty("user.dir");
		String path3 = System.getProperty("file.separator");
		System.out.println(path);
		System.out.println(path1);
		System.out.println(path3);
		
		
		List<String> list = new ArrayList<String>();
		list.add("abc");
		list.add("edd");
		String s = StringUtils.join(list,',');
		System.out.println(s);
		String[] ss =new String[]{"aa","bb"};
		String s1 = StringUtils.join(ss,',');
		System.out.println(s1);
		
		/**
		 * 根据cpu数 来决定线程池的大小
		 */
		int POOL_SIZE = 5;
		int cpuNums = Runtime.getRuntime().availableProcessors();
		ExecutorService executorService =Executors.newFixedThreadPool(cpuNums * POOL_SIZE);
		System.out.println(cpuNums);

	}

}
