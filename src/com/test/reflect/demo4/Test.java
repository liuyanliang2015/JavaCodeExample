/**
 * 
 */
package com.test.reflect.demo4;

import java.lang.reflect.Proxy;

/**
 * @author LiuYanliang
 *
 */
public class Test {
	public static void main(String[] args) {
		UserDao ud = new UserDaoImpl();
		MyInvocationHandler myInvocationHandler = new MyInvocationHandler(ud);
		//创建ud的动态代理对象
		UserDao proxy = (UserDao)Proxy.newProxyInstance(ud.getClass().getClassLoader(), ud.getClass().getInterfaces(), myInvocationHandler);
		proxy.login();
	}
}
