package com.test.thread.sync;
public class ThreadDemo2 extends Thread{
	//定义100张票
	private static int tickets = 100;
	
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			 sell();
		}
	}
	
	//售票方法
	public  void sell() {
		synchronized (ThreadDemo2.class) {
			if(tickets > 0){
				tickets--;
				System.out.println(Thread.currentThread().getName()+":"+tickets);
			}
		}
		
	}
	
	//测试main
	public static void main(String[] args) {
		ThreadDemo2 t1 = new ThreadDemo2();
		t1.setName("窗口1");
		t1.start();
		
		ThreadDemo2 t2 = new ThreadDemo2();
		t2.setName("窗口2");
		t2.start();
		
		ThreadDemo2 t3 = new ThreadDemo2();
		t3.setName("窗口3");
		t3.start();
	}

}
