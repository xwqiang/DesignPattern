package com.test.ref.cache.liteCache;

public class Test {
	String key ;
	public Test(){
		key = "abc";//key的值可以从配置文件中获取
	}
	public void setKey(String key){
		this.key = key;
	}
	public static void main(String[] a ){
		Test t = new Test();//想通过一个方法 不改变构造方法的前提下，改变key的值，比如可以通过读取配置文件，还有其他的什么方法吗
		t.setKey("bbb");
	}
}
