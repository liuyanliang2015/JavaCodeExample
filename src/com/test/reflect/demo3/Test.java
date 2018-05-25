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
		Student s = new Student("¡ı±∏",40);
		Tool.setProperty(s, "name", "’≈∑…");
		System.out.println(s); //Student [name=’≈∑…, age=40]
	}

}
