package com.test.outOfMemory;

/**
 * 模拟栈溢出
 * A:使用-Xss参数减少栈内存的容量，结果抛出java.lang.StackOverflowError，异常出现的栈深度相应缩小
 * B:定义大量的本地变量，增加此方法帧中本地变量表的长度，结果StackOverflowError异常出现的栈深度相应缩小
 * -Xss256k  stackLength:2488
 * -Xss128k  stackLength:1005
 */
public class TestOutOfMemory2 {
	private int stackLength = 1;
	public void stackLeak(){
		stackLength ++;
		stackLeak();
	}
	public static void main(String[] args) {
		TestOutOfMemory2 t = new TestOutOfMemory2();
		try {
			t.stackLeak();
		} catch (Throwable e) {
			System.out.println("stackLength:"+t.stackLength);
			//e.printStackTrace();
			throw e;
		}
		
	}
	
}
