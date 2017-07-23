package com.test;


public class jvmtest {
	private static int a=1024*1024;
	public static void main(String[] args) {
		testobjectage();
		//testgc();
	}
	public static void testobjectage(){
		byte[] b2 = new byte[1/4*a];
		byte[] b3 = new byte[4*a];
		byte[] b5 = new byte[4*a];
		b5=null;
		b5 = new byte[4*a];
	}
	public static void testgc(){
		byte[] b2 = new byte[2*a];
		byte[] b3 = new byte[2*a];
		byte[] b5 = new byte[2*a];
		byte[] b6 = new byte[4*a];
	}
}
