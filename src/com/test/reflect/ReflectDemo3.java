/**
 * 
 */
package com.test.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @author LiuYanliang
 *
 */
public class ReflectDemo3 {
	public static void main(String[] args) throws Exception {
		//(1)获取字节码文件对象
		Class c  = Class.forName("com.test.reflect.Person");
		//获取public公共成员方法(包含父类中的方法)
		//Method[] methods = c.getMethods();
		//获取所有的成员方法(不包含父类)
		/*Method[] methods = c.getDeclaredMethods();
		for(Method m : methods){
			System.out.println(m);
		}*/
		
		//(2)获取成员方法对象
		Method showMethod = c.getMethod("show");
		Method meMethod = c.getDeclaredMethod("method", String.class);
		Method functionMethod = c.getDeclaredMethod("function");
		functionMethod.setAccessible(true);
		
		Method getStringMethod = c.getDeclaredMethod("getString", String.class,int.class);
		//(3)通过无参构造方法创建对象
		Constructor con = c.getConstructor();
		Object obj = con.newInstance();
		//(4)执行方法
		showMethod.invoke(obj);
		meMethod.invoke(obj, "hello");
		functionMethod.invoke(obj);
		String result = (String)getStringMethod.invoke(obj,"hello",5);
		System.out.println("result:"+result);
	}

}
