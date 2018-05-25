package com.test.thread.volatileDemo;


/**
 * 为了这个问题，java 提供了volatile关键字。
 * 当isRunning变量被volatile修饰，则当变量改变的时候，会强制线程执行引擎去主内存里面读取变量的值
 */
public class VolatileDemo2 extends Thread{
	
	private volatile boolean isRunning = true;
	
	private void setRunning(boolean isRunning){
		this.isRunning = isRunning;
	}
	
	
	@Override
	public void run() {
		while (isRunning == true) {
		}
		System.out.println("线程结束");
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		
		VolatileDemo2 t = new VolatileDemo2();
		t.start();
		//加延迟的目的是让主线程set isRunning = false慢于线程的启动
        //线程的启动是一个耗时的过程
        //否则线程启动，重新开辟内存工作空间的时候，主内存已经set false了
		Thread.sleep(3000);
		
		t.setRunning(false);
		System.out.println("set running = false");
		Thread.sleep(1000);
		
		System.out.println(t.isRunning);
		
		
		
		
	}

}
