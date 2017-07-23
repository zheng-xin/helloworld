package com.thread;

public class canku {
	private int counts;

	public int getCounts() {
		return counts;
	}

	public void setCounts(int counts) {
		this.counts = counts;
	}

	public synchronized void shengchan() {
		while (counts>10) {
			try {
				System.out.println("生产等待");
				this.wait();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		counts++;
		System.out.println("生产了" + 1 + "件产品"+"还有"+counts+"件商品");
		this.notify();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public synchronized void buy() {
		while (counts == 0) {
			try {
				System.out.println("消费等待");
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		counts--;
		System.out.println("消费了1件山品还剩"+counts+"件商品");
		this.notify();
	}
}
