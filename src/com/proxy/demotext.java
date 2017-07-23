package com.proxy;
import java.lang.reflect.Proxy;



public class demotext {
	public static void main(String[] args){
		
		Test t=new Test();
		testinterface pt=(testinterface) Proxy.newProxyInstance(t.getClass().getClassLoader(), t.getClass().getInterfaces(),new proxytext(t));
		pt.text();
	}
}	
