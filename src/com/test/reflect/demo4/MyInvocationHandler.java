/**
 * 
 */
package com.test.reflect.demo4;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler{
	private Object target;//目标对象
	
	public MyInvocationHandler(Object target){
		this.target = target;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)throws Throwable {
		Object result = method.invoke(target, args);
		System.out.println("记录日志");
		return result;
	}

}
