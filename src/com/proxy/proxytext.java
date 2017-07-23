package com.proxy;

import java.lang.reflect.Method;



public class proxytext implements  java.lang.reflect.InvocationHandler{
	private Object proxy;
	public proxytext(Object proxy) {
		this.proxy=proxy;
	}
	@Override
	public Object invoke(Object arg0, Method arg1, Object[] arg2) throws Throwable {
		System.out.println("开始");
		Object result = arg1.invoke(proxy, arg2);
		System.out.println("结束");
		return result;
	}

}
