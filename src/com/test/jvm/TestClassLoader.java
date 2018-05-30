package com.test.jvm;

/**
 * 可以断点调试一下，观察执行顺序以及temp值的变化过程
 * remark1:静态代码块，如果放在最前面，里面的变量只能赋值，不能使用
 * remark2:注意区别构造器与构造方法。构造器是构造类class的，构造方法是实例化对象的。
 */
public class TestClassLoader {
	//构造器：static变量、static{}代码块  
	//构造器按代码顺序执行
	//静态变量，temp初始 = 0，然后复制成1
	public static int temp = 1;
	//静态代码块
	static {
		temp = 2;
		System.out.println(temp);
	}

	public static void main(String[] args) {
		temp = 3;
		System.out.println(temp);
		
		//sun.misc.Launcher$AppClassLoader@7692ed85  应用程序类加载器
		System.out.println(TestClassLoader.class.getClassLoader());
		
		//sun.misc.Launcher$ExtClassLoader@2827f394
		System.out.println(TestClassLoader.class.getClassLoader().getParent());
		
		//Bootstrap ClassLoader 用C++编写，我们看不见，所以是null
		System.out.println(TestClassLoader.class.getClassLoader().getParent().getParent());
	}

}
