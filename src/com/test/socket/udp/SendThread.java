/**
 * 
 */
package com.test.socket.udp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author LiuYanliang
 * 
 */
public class SendThread implements Runnable {

	private DatagramSocket sendDs;


	public SendThread( DatagramSocket sendDs) {
		this.sendDs = sendDs;
	}

	@Override
	public void run() {
		try {
			//封装键盘录入数据
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        String line = null;
	        while((line = br.readLine())!= null){
	            if("886".equals(line)){
	                break;
	            }
	            // 创建数据，并把数据打包
	            byte[] bys = line.getBytes();
	            DatagramPacket dp = new DatagramPacket(bys, bys.length,InetAddress.getByName("192.168.9.255"), 8888);
	            // 调用Socket的send方法，发送数据包
	            sendDs.send(dp);
	        }
	        // 释放资源
	        sendDs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
			
		}

	}

