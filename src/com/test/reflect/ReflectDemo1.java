/**
 * 
 */
package com.test.reflect;

import java.lang.reflect.Constructor;

/**
 * @author LiuYanliang
 *
 */
public class ReflectDemo1 {
		public static void main(String[] args) throws Exception {
			//(1)获取Class对象，必须带全路径，带包名
			Class c4 = Class.forName("com.test.reflect.Person");
			//(2)获取构造方法对象
			Constructor  c = c4.getDeclaredConstructor(String.class,int.class);
			System.out.println(c);//public com.test.reflect.Person(java.lang.String,int,java.lang.String)
			//暴力访问私有构造器，值为true则指示反射的对象在使用时应该取消Java语言访问检查
			c.setAccessible(true);
			//使用构造方法对象的方法,创建对象
			Object obj  = c.newInstance("林青霞",27);
			System.out.println(obj);
		}

}
