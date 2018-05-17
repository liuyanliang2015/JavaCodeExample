/**
 * 
 */
package com.test.thread.runnableDemo;

/**
 * @author LiuYanliang
 */
public class SellTicket implements Runnable {
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
								+ "���ڳ��۵�" + (tickets--) + "��Ʊ");
					} else {
						System.out.println(Thread.currentThread().getName()
								+ "Ʊ������");
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
			System.out.println(Thread.currentThread().getName() + "���ڳ��۵�"
					+ (tickets--) + "��Ʊ");
		} else {
			System.out.println(Thread.currentThread().getName() + "Ʊ������");
			flag = false;
		}
		return flag;

	}
}
