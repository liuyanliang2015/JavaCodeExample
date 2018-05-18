package com.test.jvm;

/**
 * 扩大Survivor区比例
 * -Xmx20m -Xms20m -Xmn7m -XX:SurvivorRatio=2 -XX:+PrintGCDetails
 *
 */
public class TestXmn04 {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		byte[] b = null;
		for(int i = 0; i < 10 ;i++){
			b = new byte[1*1024*1024];
		}
	}

}
