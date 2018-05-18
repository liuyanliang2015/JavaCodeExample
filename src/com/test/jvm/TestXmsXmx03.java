package com.test.jvm;

/**
 * -Xmx20m -Xms5m
 * @author Administrator
 *
 */
public class TestXmsXmx03 {
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
	    byte[] b = new byte[7*1024*1024];
		System.out.println("分配了7M空间给b数组");
		
		System.out.print("Xmx=");
		System.out.println(Runtime.getRuntime().maxMemory()/1024/1024 + "M");
		
		System.out.print("free=");
		System.out.println(Runtime.getRuntime().freeMemory()/1024/1024 + "M");
		
		System.out.print("total=");
		System.out.println(Runtime.getRuntime().totalMemory()/1024/1024 + "M");
	} 

}
