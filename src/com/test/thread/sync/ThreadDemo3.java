package com.test.thread.sync;
/**
 *synchronized代码块，具体看锁住的对象是什么，该对象在内存中是否唯一
 *本例锁的是ThreadDemo3.class，等效于ThreadDemo2
 */
public class ThreadDemo3 extends Thread{
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
		synchronized (ThreadDemo3.class) {
			if(tickets > 0){
				tickets--;
				System.out.println(Thread.currentThread().getName()+":"+tickets);
			}
		}
	}
	
	//测试main
	public static void main(String[] args) {
		ThreadDemo3 t1 = new ThreadDemo3();
		t1.setName("窗口1");
		t1.start();
		
		ThreadDemo3 t2 = new ThreadDemo3();
		t2.setName("窗口2");
		t2.start();
		
		ThreadDemo3 t3 = new ThreadDemo3();
		t3.setName("窗口3");
		t3.start();
	}

}
