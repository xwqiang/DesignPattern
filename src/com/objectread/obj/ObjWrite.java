package com.objectread.obj;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ObjWrite {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String dir = System.getProperty("user.dir");
		File file = new File(dir);
		if(!file.exists()){
			file.mkdirs();
		}
		List<String> list = new ArrayList<String>();
		for(int i = 0;i<=100;i++){
			list.add("item"+i);
		}
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(new File(dir+"/cachedata.dat")));
			oos.writeObject(list);
			oos.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
