/**
 * 
 */
package com.test.thread.lockDemo;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author LiuYanliang
 */
public class SellTicket implements Runnable {
	// 定义100张票
	private static int tickets = 100;
	private final ReentrantLock lock = new ReentrantLock();

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {

			try {
				// 获取锁
				lock.lock();
				if (tickets > 0) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName()
							+ "正在出售第" + (tickets--) + "张票");
				} else {
					System.out.println(Thread.currentThread().getName()
							+ "票卖完了");
					break;
				}
			} finally {
				// 释放锁
				lock.unlock();
			}

		}

	}

}
