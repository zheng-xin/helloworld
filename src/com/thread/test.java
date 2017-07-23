package com.thread;

public class test {
	
	public static void main(String[] args) {
		canku ku=new canku();
		customer c=new customer(ku);
		productor p=new productor(ku);
		Thread c1=new Thread(c);
		Thread p1=new Thread(p);
		c1.start();
		p1.start();
	}
}
