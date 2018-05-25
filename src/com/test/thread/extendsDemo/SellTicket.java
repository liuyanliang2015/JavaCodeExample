/**
 * 
 */
package com.test.thread.extendsDemo;

/**
 * @author LiuYanliang
 */
public class SellTicket extends Thread {
	
	//定义100张票(多个线程共享资源)
	private static int tickets = 100;
			
	@Override
	public void run() {
		while(true){
			if(tickets > 0){
				System.out.println(getName()+"正在出售第"+(tickets--)+"张票");
			}else{
				System.out.println("票卖完了");
				break;
			}
		}
		
	}

}
