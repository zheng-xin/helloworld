package com.thread;

public class customer implements Runnable {
	private canku ku;
	public customer(canku ku){
		this.ku=ku;
	}
	@Override
	public void run() {
		while(true){
			ku.buy();
		}
		
	}
	

}
