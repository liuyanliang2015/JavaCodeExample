/**
 * 
 */
package com.test.thread.extendsDemo;

/**
 * @author LiuYanliang
 *
 */
public class SellTicketTest {
	public static void main(String[] args) {
		SellTicket st1 = new SellTicket();
		SellTicket st2 = new SellTicket();
		SellTicket st3 = new SellTicket();
		st1.setName("窗口1");
		st2.setName("窗口2");
		st3.setName("窗口3");
		
		st1.start();
		st2.start();
		st3.start();
	}

}
