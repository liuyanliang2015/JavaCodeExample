/**
 * 
 */
package com.test.thread.producerConsumers;


/**
 *包子生产者线程
 */
public class ProduceBaoZiThread implements Runnable {
	private BaoZi bz;
	private int x = 0;
	/**
	 * @param bz
	 */
	public ProduceBaoZiThread(BaoZi bz) {
		this.bz = bz;
	}

	@Override
	public void run() {
		
		while(true){
			synchronized (bz) {
				if(bz.flag){
					try {
						bz.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				
				if(x % 2 == 0){
					bz.setName("猪肉大葱包子");
					bz.setPrice(2.0f);
				}else{
					bz.setName("韭菜鸡蛋包子");
					bz.setPrice(1.5f);
				}
				x++;
				bz.flag = true;
				bz.notify();
			}
			
		}
		
	}

}
