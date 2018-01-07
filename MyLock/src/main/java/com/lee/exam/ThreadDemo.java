package com.lee.exam;

public class ThreadDemo {
	public static void main(String[] args) {
		ShareData data = new ShareData();
		new Thread(()->{
			for (int i = 0; i < 26; i++) {
				try {
					data.increment();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		},"A").start();
		new Thread(()->{
			for (int i = 0; i < 26; i++) {
				try {
					data.decrement();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		},"B").start();
	}
}
class ShareData{
	private int num = 1;
	private boolean b = true;
	public synchronized void increment() throws InterruptedException {
			while(b==false) {
				this.wait();
			}
			System.out.print(" "+num+++num++);
			b=false;
			this.notifyAll();
	}
	
	public synchronized void decrement() throws InterruptedException {
			while(b==true) {
				this.wait();
			}
			System.out.print(" "+(char)(64+num/2));
			b=true;
			this.notifyAll();
	}
}