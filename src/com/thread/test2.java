package com.thread;

public class test2 implements Runnable {
	 private int num;
	      private Object lock;
	      
	      public test2(int num, Object lock) {
	          super();
	          this.num = num;
	          this.lock = lock;
	     }
	 
	     public void run() {
	         try {
	             while(true){
	                 synchronized(lock){
	                	 System.out.println("线程"+num+"进入");
	                	 System.out.println(num+"notify");
	                     lock.notifyAll();
	                     lock.wait();
	                     System.out.println(num+"等待");
	                     System.out.println(num);
	                 }
	             }
	         } catch (InterruptedException e) {
	             // TODO Auto-generated catch block
	             e.printStackTrace();
	         }
	         
	     }
	     
	     public static void main(String[] args){
	         final Object lock = new Object();
	         
	         Thread thread1 = new Thread(new test2(1,lock));
	         Thread thread2 = new Thread(new test2(2, lock));
	         
	         thread1.start();
	         thread2.start();
	     }
}
