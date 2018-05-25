package com.test.thread.sync;

/**
 * static synchronized 锁住的是当前类的class对象
 * 该对象在JVM内存中只有一份，不会重复加载，所以三个线程只有一把锁，会线程阻塞，实现同步的效果
 * 
 * 举个例子：三个人上厕所，只有一个坑，一把锁。一个人进去，上锁，其他人只能等着。
 * 等里面的人出来，释放锁，别人才能接住锁，入坑。
 *
 */
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
	public static synchronized  void sell() {
			if(tickets > 0){
				tickets--;
				System.out.println(Thread.currentThread().getName()+":"+tickets);
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
