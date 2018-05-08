package com.test.outOfMemory;

import java.util.ArrayList;
import java.util.List;

/**
 * 模拟堆溢出
 * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 *
 */
public class TestOutOfMemory1 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		while(true){
			list.add("abcdefg");
		}
	}

}
