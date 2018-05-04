/**
 * 
 */
package com.test.thread.callable;

import java.util.concurrent.Callable;

/**
 *线程求和
 */
public class MyCallable implements Callable<Integer> {
	private int number;
	
	public MyCallable(int number){
		this.number = number;
		
	}
	
	@Override
	public Integer call() throws Exception {
		int sum = 0;
		for(int i = 0; i<=number;i++){
			sum+= i;
		}
		return sum;
	}

}
