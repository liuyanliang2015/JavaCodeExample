/**
 * 
 */
package com.test.reflect;

/**
 * @author LiuYanliang
 *
 */
public class Person {
	private String name;
	int age;
	public String address;
	
	public Person() {
		
	}


	/**
	 * @param name
	 * @param age
	 */
	private Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}


	/**
	 * @param name
	 * @param age
	 * @param address
	 */
	public Person(String name, int age, String address) {
		super();
		this.name = name;
		this.age = age;
		this.address = address;
	}
	
	
	public void show(){
		System.out.println("show");
	}
	
	public void method(String s){
		System.out.println("method"+s);
	}
	
	public String  getString(String s,int a){
		return s+"---"+a;
	}
	
	private void function(){
		System.out.println("function");
	}


	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", address=" + address
				+ "]";
	}

}
