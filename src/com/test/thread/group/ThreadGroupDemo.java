/**
 * 
 */
package com.test.thread.group;


/**
 * @author LiuYanliang
 */
public class ThreadGroupDemo {
	public static void main(String[] args) {
		MyThread my = new MyThread();
		ThreadGroup group = new ThreadGroup("test");
		Thread t1 = new Thread(group,my,"线程1");
		Thread t2 = new Thread(group,my,"线程2");
		System.out.println(t1.getThreadGroup().getName()); //test
		System.out.println(t2.getThreadGroup().getName()); //test
		group.setDaemon(true);
		group.setMaxPriority(10);
	}

}
