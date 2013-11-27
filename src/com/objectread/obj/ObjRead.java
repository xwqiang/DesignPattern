package com.objectread.obj;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class ObjRead {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File f = new File(System.getProperty("user.dir")+"/cachedata.dat");
		ObjectInputStream ois = null;
		Object obj = null;
		try {
			ois = new ObjectInputStream(new FileInputStream(f));
			obj = ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		List<String> list = (ArrayList)obj;
		for(String s: list){
			System.out.println(s);
		}
		f.delete();
		

	}

}
