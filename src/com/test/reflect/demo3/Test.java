/**
 * 
 */
package com.test.reflect.demo3;


/**
 * @author LiuYanliang
 *
 */
public class Test {
	public static void main(String[] args) throws Exception {
		Student s = new Student("刘备",40);
		Tool.setProperty(s, "name", "张飞");
		System.out.println(s); //Student [name=张飞, age=40]
	}

}
