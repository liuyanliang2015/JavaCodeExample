/**
 * 
 */
package com.test.thread.callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author LiuYanliang
 * 
 */
public class CallableDemo {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// 创建线程池对象
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		//执行Callable
		Future<Integer> result1 = executorService.submit(new MyCallable(10));
		System.out.println(result1.get()); //55
		
		Future<Integer> result2 = executorService.submit(new MyCallable(100));
		System.out.println(result2.get());//5050
		//关闭线程池
		executorService.shutdown();
	}

}
