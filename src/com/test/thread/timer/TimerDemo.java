/**
 * 
 */
package com.test.thread.timer;

import java.text.ParseException;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author LiuYanliang
 *
 */
public class TimerDemo {
	public static void main(String[] args) throws ParseException {
		final Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				System.out.println("run");
				//timer.cancel();
			}
		},3000,2000);
	}

}
