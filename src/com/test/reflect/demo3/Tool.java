/**
 * 
 */
package com.test.reflect.demo3;

import java.lang.reflect.Field;

/**
 * @author LiuYanliang
 *
 */
public class Tool {
	public static  void setProperty(Object obj,String propertyName,Object value) throws Exception{
		Class c = obj.getClass();
		Field f = c.getDeclaredField(propertyName);
		f.setAccessible(true);
		f.set(obj, value);
	}

}
