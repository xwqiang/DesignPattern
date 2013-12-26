package com.test.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//代理类
public class LogHandler implements InvocationHandler {
	
	private Object targetObject;
	
	public Object newProxyInstance(Object targetObject) {
		this.targetObject = targetObject;
		return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(),
							   targetObject.getClass().getInterfaces(), this);
	}
	
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("start-->>" + method.getName());
		for (int i=0; i<args.length; i++) {
			System.out.println(args[i]);
		}
		Object ret = null;
		try {
			//调用目标方法
			ret = method.invoke(targetObject, args);
			System.out.println("success-->>" + method.getName()); 
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("error-->>" + method.getName());
			throw e;
		}
		return ret;
	}

}

