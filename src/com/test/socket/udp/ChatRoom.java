/**
 * 
 */
package com.test.socket.udp;

import java.net.DatagramSocket;

/**
 * @author LiuYanliang
 *
 */
public class ChatRoom {
	public static void main(String[] args) throws Exception {
		DatagramSocket dsSend = new DatagramSocket();
		DatagramSocket dsReiceive = new DatagramSocket(8888);
		
		ReceiveThread rt1 = new ReceiveThread(dsReiceive);
		SendThread rt2 = new SendThread(dsSend);
		
		Thread t1 = new Thread(rt1);
		Thread t2 = new Thread(rt2);
		
		t1.start();
		t2.start();
	}

}
