package com.test.thread.sync;
public class ThreadDemo extends Thread{
	//定义100张票
	private static int tickets = 100;
	
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			 sell();
		}
	}
	
	//售票方法
	public void sell() {
		if(tickets > 0){
			tickets--;
			System.out.println(Thread.currentThread().getName()+":"+tickets);
		}
		
	}
	
	//测试main
	public static void main(String[] args) {
		ThreadDemo t1 = new ThreadDemo();
		t1.setName("窗口1");
		t1.start();
		
		ThreadDemo t2 = new ThreadDemo();
		t2.setName("窗口2");
		t2.start();
		
		ThreadDemo t3 = new ThreadDemo();
		t3.setName("窗口3");
		t3.start();
	}

}
