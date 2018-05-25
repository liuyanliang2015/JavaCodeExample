package com.test.thread.threadLocalDemo;

public class MyThreadLocal1 {
	 public static String threadLocal = null;
     
	    public void setThreadLocal(String value){
	    	threadLocal = value;
	    }
	    public void getThreadLocal(){
	        System.out.println(Thread.currentThread().getName()+" :　"+ threadLocal);
	    }
	     
	    public static void main(String[] args) {
	        final MyThreadLocal1 mtl = new MyThreadLocal1();
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
