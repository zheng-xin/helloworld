package com.user.text;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

import com.user.entity.user;

public class test {
	public static void main(String[] args) throws InterruptedException {
		user u=new user();
		ReferenceQueue<user> queue = new  ReferenceQueue<user>();
		SoftReference<user>  ref=new  SoftReference<user>(u, queue);
		u=null;
		//Thread.sleep(500);
		 System.out.println(queue.poll()==null);
	}
}	
