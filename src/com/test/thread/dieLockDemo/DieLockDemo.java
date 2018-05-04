/**
 * 
 */
package com.test.thread.dieLockDemo;

/**
 * @author LiuYanliang
 *
 */
public class DieLockDemo {
	public static void main(String[] args) {
		DieLock dl1 = new DieLock(true);
		DieLock dl2 = new DieLock(false);
		dl1.start();
		dl2.start();
	}
}
