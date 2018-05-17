package com.test.jvm;

public class TestJvm {
	
	public static void main(String[] args) {
		//考察1：内存分析
		String a = "abcd";
		String b = "abcd";
		System.out.println(a == b);
		
		String c = new String("abcd");
		String d = new String("abcd");
		System.out.println(c == d);
		
		//考察2：自动装箱的源码Integer.valueOf(int i)
		Integer e = 10;
		Integer f = 10;
		System.out.println(e == f);
		
		Integer g = 200;
		Integer h = 200;
		System.out.println(g == h);
		
	}

}
