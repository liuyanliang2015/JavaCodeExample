/**
 * 
 */
package com.test.thread.group;

/**
 * @author LiuYanliang
 *
 */
public class MyThread implements Runnable {

	@Override
	public void run() {
		for(int i = 0 ;i < 10; i++){
			System.out.println(i);
		}
	}

}
