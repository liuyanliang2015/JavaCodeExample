/**
 * 
 */
package com.test;

import java.util.Random;

/**
 * @author LiuYanliang
 * 
 */
public class Test {
	public static void main(String[] args) {
		Random random = new Random();
		int num = random.nextInt(25) + 1;
		System.out.println(num);
	}

}
