/**
 * 
 */
package com.test.thread.runnableDemo;

/**
 * @author LiuYanliang
 *
 */
public class SellTicketTest {
	public static void main(String[] args) {
		SellTicket st = new SellTicket();
		
		Thread t1 = new Thread(st);
		Thread t2 = new Thread(st);
		Thread t3 = new Thread(st);
		
		t1.setName("´°¿Ú1");
		t2.setName("´°¿Ú2");
		t3.setName("´°¿Ú3");
		
		t1.start();
		t2.start();
		t3.start();
	}

}
