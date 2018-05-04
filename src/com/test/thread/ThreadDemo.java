/**
 * 
 */
package com.test.thread;

/**
 * @author LiuYanliang
 *
 */
public class ThreadDemo {
	public static void main(String[] args) {
		//继承Thread类
		new Thread(){
			public void run() {
				for(int i = 0 ;i<100;i++){
					System.out.println(Thread.currentThread().getName()+":"+i);
				}
			};
			
		}.start();
		
		
		//实现Runnable接口
		new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i = 0 ;i<100;i++){
					System.out.println(Thread.currentThread().getName()+":"+i);
				}
			}
		}){
			
		}.start();
	}

}
