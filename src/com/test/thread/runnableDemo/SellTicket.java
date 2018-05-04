/**
 * 
 */
package com.test.thread.runnableDemo;

/**
 * @author LiuYanliang
 */
public class SellTicket implements Runnable {
	// 定义100张票
	private static int tickets = 100;

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			if (i % 2 == 0) {
				synchronized (SellTicket.class) {
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
				}
			} else {
				boolean flag = sell();
				if (flag == false) {
					break;
				}
			}

		}
	}

	/**
	 * static synchronized同步方法
	 * @return
	 */
	public static synchronized boolean sell() {
		boolean flag = true;
		if (tickets > 0) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "正在出售第"
					+ (tickets--) + "张票");
		} else {
			System.out.println(Thread.currentThread().getName() + "票卖完了");
			flag = false;
		}
		return flag;

	}
}
