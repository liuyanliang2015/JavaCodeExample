/**
 * 
 */
package com.test.thread.producerConsumers;

/**
 * ≤‚ ‘¿‡
 */
public class BaoZiDemo {
	public static void main(String[] args) {
		BaoZi bz  = new BaoZi();
		ProduceBaoZiThread pb = new ProduceBaoZiThread(bz);
		ConsumeBaoZiThread cb = new ConsumeBaoZiThread(bz);

		Thread t1 = new Thread(pb);
		Thread t2 = new Thread(cb);

		t1.start();
		t2.start();
	}

}
