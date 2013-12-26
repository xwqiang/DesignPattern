package com.test.dynamicProxy;

//客户端
public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LogHandler logHandler = new LogHandler();
		UserManager userManager = (UserManager)logHandler.newProxyInstance(new UserManagerImpl());
		userManager.addUser("0001","张三");	
	}

}
