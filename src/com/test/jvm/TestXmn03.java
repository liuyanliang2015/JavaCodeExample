package com.test.jvm;

/**
 * 新生代：Xmn不大也不小
 * -Xmx20m -Xms20m -Xmn7m -XX:+PrintGCDetails
 *
 */
public class TestXmn03 {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		byte[] b = null;
		for(int i = 0; i < 10 ;i++){
			b = new byte[1*1024*1024];
		}
	}

}
