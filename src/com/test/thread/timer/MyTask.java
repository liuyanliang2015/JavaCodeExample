/**
 * 
 */
package com.test.thread.timer;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author LiuYanliang
 *
 */
public class MyTask extends TimerTask {
	Timer timer;
	/**
	 * @param timer
	 */
	public MyTask(Timer timer) {
		this.timer = timer;
	}

	@Override
	public void run() {
		System.out.println("run");
		timer.cancel();
	}

}
