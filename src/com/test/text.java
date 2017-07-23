package com.test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class text {
	private static text t=null;
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		System.out.println("finalize");
		System.out.println(this);
		t=this;
	}
	public static void main(String[] args) throws InterruptedException {
	    t=new text();
		t=null;
		System.gc();
		Thread.sleep(500);
		if(t==null){
			System.out.println("被回收了");
		}
		else{
			System.out.println("活着呢");
		}
		
	}
}
