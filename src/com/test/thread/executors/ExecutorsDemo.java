/**
 * 
 */
package com.test.thread.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author LiuYanliang
 *
 */
public class ExecutorsDemo {
	public static void main(String[] args) {
		//创建线程池对象
		ExecutorService  executorService = Executors.newFixedThreadPool(2);
		
		//执行线程
		executorService.submit(new MyThread());
		executorService.submit(new MyThread());
		
		//结束线程池
		executorService.shutdown();
	}
}
