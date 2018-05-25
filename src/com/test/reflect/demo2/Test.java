/**
 * 
 */
package com.test.reflect.demo2;

import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * @author LiuYanliang
 *
 */
public class Test {
	public static void main(String[] args) throws Exception {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		//arrayList.add("hello"); error
		arrayList.add(10);
		//通过看add()源码，可以看出，其实底层需要传的是E，默认是Object
		//泛型只是给编译器看的,通过反编译，可以看出来，运行的时候，其实是没有泛型的
		
		//通过反编译存储字符串
		Class c = arrayList.getClass();
		Method addMethod = c.getMethod("add", Object.class);
		addMethod.invoke(arrayList, "hello");
		System.out.println(arrayList); //[10, hello]
	}
}
