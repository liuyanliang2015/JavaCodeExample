package com.test.jvm.myClassLoader;

public class Test {
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		MyClassLoader loader = new MyClassLoader("myloader", "D:/tmp/");
		//hello world:com.test.jvm.myClassLoader.MyClassLoader@32f22097
		//Class c = loader.loadClass("Demo");
		
		//hello world:sun.misc.Launcher$AppClassLoader@6d4b473
		//双亲委派加载机制
		Class c = loader.loadClass("com.test.jvm.myClassLoader.Demo");
		c.newInstance();
	}
}
