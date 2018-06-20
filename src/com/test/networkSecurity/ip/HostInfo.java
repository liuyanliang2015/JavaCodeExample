package com.test.networkSecurity.ip;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class HostInfo {
	private final String HOST_NAME;
	private final String HOST_ADDRESS;
	
	public HostInfo(){
		String hostName = null;
		String hostAddress = null;
		try {
			InetAddress localhost = InetAddress.getLocalHost();
			hostName = localhost.getHostName();
			hostAddress = localhost.getHostAddress();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		HOST_NAME = hostName;
		HOST_ADDRESS = hostAddress;
	}
	
	public final String getHostName(){
		
		return HOST_NAME;
	}
	
	public final String getHostAddress(){
		
		return HOST_ADDRESS;
	}
	
	
	public static void main(String[] args) {
		HostInfo hi = new HostInfo();
		System.out.println(hi.getHostName());
		System.out.println(hi.getHostAddress());
	}

}
