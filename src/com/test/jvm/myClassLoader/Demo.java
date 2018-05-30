package com.test.jvm.myClassLoader;

public class Demo {
	public Demo() {
		System.out.println("hello world:" + this.getClass().getClassLoader());
	}
}
