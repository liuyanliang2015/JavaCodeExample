package com.test.outOfMemory;

import java.util.ArrayList;
import java.util.List;

/**
 * 模拟堆溢出
 * java.lang.OutOfMemoryError: Java heap space
 * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 *
 */
public class TestOutOfMemory1 {
	public static void main(String[] args) {
		List<byte[]> list = new ArrayList<byte[]>();
		for(int i = 0; i <1024;i++){
			list.add(new byte[1024*1024]);
		}
	}

}
