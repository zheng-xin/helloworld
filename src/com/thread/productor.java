package com.thread;

public class productor implements Runnable{
	private canku ku;
	public productor(canku ku){
		this.ku=ku;
	}
	@Override
	public void run() {
		while(ku.getCounts()<=20){
			ku.shengchan();
		}
	}
}
