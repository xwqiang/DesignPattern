package com.test.dynamicProxy;

//目标类

public class UserManagerImpl implements UserManager {

	public void addUser(String userId, String userName) {
		try {
			System.out.println("AddUser" );
		}catch(Exception e){
		}
	}
}

