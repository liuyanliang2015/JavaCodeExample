package com.test.thread;

import java.util.ArrayList;
import java.util.List;


/**
 * java.lang.ArrayIndexOutOfBoundsException
 * ArrayList会自动扩展容量，为什么会越界呢？
 * 这是因为多线程操作ArrayList(非线程安全的),
 * 扩容的时候，是处于一个不可用的状态，这时候其他线程访问，就会出现越界错误
 * 解决办法：run方法里面加synchronize代码块
 *
 */
public class AddToArrayListDemo {
	
	public static List<Integer> numberList = new ArrayList<Integer>();
	
	public static class AddToList implements Runnable{
		int startnum = 0;
		public AddToList(int startNumber){
			startnum = startNumber;
		}

		@Override
		public void run() {
			int count = 0;
			while(count < 1000000){
				numberList.add(startnum);
				startnum += 2;
				count ++;
			}
		}
		
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new AddToList(0));
		Thread t2 = new Thread(new AddToList(1));
		t1.start();
		t2.start();
		while(t1.isAlive() || t2.isAlive() ){
			Thread.sleep(1);
		}
		System.out.println(numberList.size());
		
	}
	

}
