package com.test.thread.threadLocalDemo;

/**
 * 线程局部变量，是一种多线程间并发访问变量的解决方案
 * 与其synchronized等加锁的方式不同，ThreadLocal完全不提供锁，而使用以空间换时间的手段，为每个线程提供变量的独立副本，以保障线程安全。
 * 变量是同一个，但是每个线程都使用同一个初始值，也就是使用同一个变量的一个新的副本
 *
 */
public class MyThreadLocal2 {
	 public static ThreadLocal<String> threadLocal = new ThreadLocal<String>();
     
	    public void setThreadLocal(String value){
	        threadLocal.set(value);
	    }
	    public void getThreadLocal(){
	        System.out.println(Thread.currentThread().getName()+" :　"+ threadLocal.get());
	    }
	     
	    public static void main(String[] args) {
	        final MyThreadLocal2 mtl = new MyThreadLocal2();
	        Thread t1 = new Thread(new Runnable() {
	            @Override
	            public void run() {
	                mtl.setThreadLocal("任盈盈");
	                mtl.getThreadLocal();
	            }
	        },"t1");
	         
	        Thread t2 = new Thread(new Runnable() {
	            @Override
	            public void run() {
	                try {
	                    Thread.sleep(1000);
	                    mtl.getThreadLocal();
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }
	                 
	            }
	        },"t2");
	         
	        t1.start();
	        t2.start();
	    }
}
