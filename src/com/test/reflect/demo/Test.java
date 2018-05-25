/**
 * 
 */
package com.test.reflect.demo;

import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 *开发中需求是变化的：有时候需要执行学生的love方法，有时候需要执行教师的love方法。后来又增加了工人，怎么办呢?
 *需求的变化，程序员不能控制，但是我们尽量让设计更灵活，有扩展性。
 *反射需要配合配置文件使用，这里用reflect.txt代替配置文件
 */
public class Test {
	public static void main(String[] args) throws Exception {
		/*Student s = new Student();
		s.love();
		
		Teacher t = new Teacher();
		t.love();*/
		
		Properties pros = new Properties();
		FileReader fr = new FileReader("reflect.txt");
		pros.load(fr);
		fr.close();
		
		String className = (String)pros.getProperty("className");
		String methodName = (String)pros.getProperty("methodName");
		System.out.println(className);
		System.out.println(methodName);
		
		//反射：
		//获取class字节码文件对象
		Class c = Class.forName(className);
		Method method = c.getMethod(methodName);
		
		//获取对象
		Object obj = c.newInstance();
		method.invoke(obj);
		
	}
}
