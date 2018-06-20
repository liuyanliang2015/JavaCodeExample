package com.test.jdk8;


/**
 * 函数接口指的是只有一个函数的接口
 * 注解@FunctionalInterface声明函数式接口。
 * 默认方法和静态方法不会破坏函数式接口的定义
 */
@FunctionalInterface
public interface TestFunctionalInter {
	void method1();

	//void method2(); //error
	
	default void defaultMethod(){
		
	}
	
	public static void staticMethod(){
		
	}
}
