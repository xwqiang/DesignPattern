package com.test.ref.cache.liteCache;


public class Test {

public static void main(String[] args ){
//	String s = "+0432423430";
//	StringBuilder sb = new StringBuilder(s);
//	long time = System.currentTimeMillis();
//	for(int i = 0 ;i< 10000;i++){
////		s += ""+i;//306
////		s = s.concat(i+"");//150
//		sb.append(Integer.toString(i));//3
//		sb.append(i+"");//6
//	}
//	System.out.println(System.currentTimeMillis()-time);
//	System.out.println("s-->"+s);
//	System.exit(0);
	
	
		LiteCache<UserInfo> c = new LiteCache<UserInfo>();
		c.setKey("user_id");
		try {
			for(int i = 0 ;i<1500000000;i++){
				UserInfo u = new UserInfo();
				u.setUser_id("user_"+i);
				c.put(u);
				if(i%1000==0){
					System.out.println(c.size());
				}
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("over");
	}
}
