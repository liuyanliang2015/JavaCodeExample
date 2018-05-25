/**
 * 
 */
package com.test.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * @author LiuYanliang
 *
 */
public class ReflectDemo2 {
	public static void main(String[] args) throws Exception {
		//(1)获取字节码文件对象
		Class c  = Class.forName("com.test.reflect.Person");
		//获取public公共成员变量
		//Field[] fields = c.getFields();
		//获取所有成员变量
		/*Field[] fields = c.getDeclaredFields();
		for(Field f :fields){
			System.out.println(f);
		}*/
		//(2)获取单个public成员变量
		Field addressField = c.getField("address");
		System.out.println(addressField);
		
		Field nameField = c.getDeclaredField("name");
		System.out.println(nameField);
		
		Field ageField = c.getDeclaredField("age");
		System.out.println(ageField);
		
		//(3)通过无参构造方法创建对象
		Constructor con = c.getConstructor();
		Object obj = con.newInstance();
		//(4)设置非pulic成员变量可访问:将指定对象变量上此 Field 对象表示的字段设置为指定的新值
		nameField.setAccessible(true);
		//(5)设置成员变量的值
		nameField.set(obj, "林青霞");
		ageField.set(obj, 27);
		addressField.set(obj, "北京");
		//验证
		System.out.println(obj);
	}

}
