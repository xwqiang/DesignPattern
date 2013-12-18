package com.test.generics;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;

public class File {
	static String REG_YIDONG = "^(134|135|136|137|138|139|147|148|150|151|152|154|157|158|159|182|183|184|187|188){1}\\d{8}$";
	static String ENTER = "\r\n";
	static String TAB = "\t";
	static String COMMA =",";
	public static void f(){
		try {
			BufferedReader br = new BufferedReader(new FileReader("d://777.txt"));
			String s = "";
			int all = 0;
			int selected = 0;
			FileOutputStream out = new FileOutputStream("d:/888.txt");
			while((s=br.readLine())!=null){
				selected ++;
				if(s.matches(REG_YIDONG)){
					out.write(( s + ENTER ).getBytes());
					all++;
				}
			}
			System.out.println("一共："+selected);
			System.out.println("移动号："+all);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] a){
		f();
	}
}
