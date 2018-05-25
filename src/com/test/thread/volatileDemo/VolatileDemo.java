package com.test.thread.volatileDemo;


/**
 * 执行发现，当主线程main设置isRunning=false，但是t线程还是一直没有结束
 * 说明，t线程没有感知到main线程修改isRunning的值。
 * 
 * t线程启动，JVM会给t线程开辟新的线程栈，会复制一份private boolean isRunning = true;
 * 所以main线程的变化，不会影响t的私有线程
 *
 */
public class VolatileDemo extends Thread{
	
	private boolean isRunning = true;
	
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
		
		VolatileDemo t = new VolatileDemo();
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
