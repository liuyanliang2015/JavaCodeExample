package com.test.thread.sync;
/**
 * 虽然在sell方法前面加上了同步锁synchronized
 * 但是，线程启动时，JVM会给每个线程开辟一块新的私有的线程栈
 * synchronized修饰普通方法，锁住的是当前实例对象,等价于synchronized(this){}
 * this每个线程都是不同的，相当于三个线程有三把锁，自己在自己的内存空间上锁，互不影响，没有实现同步的效果。
 * 
 * 举个例子：就相当于三个人上厕所，一人入一个坑(独立线程栈)，每个人锁住自己的门(this锁)。
 *
 */
public class ThreadDemo1 extends Thread{
	//定义100张票
	private static int tickets = 100;
	
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			 sell();
		}
	}
	
	//售票方法
	public  synchronized void sell() {
		if(tickets > 0){
			tickets--;
			System.out.println(Thread.currentThread().getName()+":"+tickets);
		}
		
	}
	
	//测试main
	public static void main(String[] args) {
		ThreadDemo1 t1 = new ThreadDemo1();
		t1.setName("窗口1");
		t1.start();
		
		ThreadDemo1 t2 = new ThreadDemo1();
		t2.setName("窗口2");
		t2.start();
		
		ThreadDemo1 t3 = new ThreadDemo1();
		t3.setName("窗口3");
		t3.start();
	}

}
