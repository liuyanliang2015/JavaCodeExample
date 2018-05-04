/**
 * 
 */
package com.test.socket.tcp;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author LiuYanliang
 *
 */
public class ChatRoom {
	public static void main(String[] args) throws Exception {
		
		ServerSocket serverSocket = new ServerSocket(8888);
		ReceiveThread rt1 = new ReceiveThread(serverSocket);
		Thread t1 = new Thread(rt1);
		t1.start();
		
		
		Socket socket = new Socket("127.0.0.1", 8888);
		SendThread rt2 = new SendThread(socket);
		Thread t2 = new Thread(rt2);
		t2.start();
	}

}
