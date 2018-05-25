/**
 * 
 */
package com.test.socket.tcp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author LiuYanliang
 * 
 */
public class ReceiveThread implements Runnable {


	private ServerSocket serverSocket;

	public ReceiveThread(ServerSocket serverSocket) {
		this.serverSocket = serverSocket;
	}

	@Override
	public void run() {
		System.out.println("r-run");
		while (true) {
			try {
				// 监听客户端连接，返回一个对应的Socket对象
		        Socket socket = serverSocket.accept();
		        // 读取数据(获取输入流，读数据，显示在控制台)-包装通道内容的流
		        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		        String line = null;
		        while ((line = br.readLine()) != null) {
		            String ip = socket.getInetAddress().getHostAddress();
		            System.out.println(ip + "->" + line);
		        }
		        //释放资源
		        socket.close();
		        //serverSocket.close(); 服务器不关闭
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}

	}

}
