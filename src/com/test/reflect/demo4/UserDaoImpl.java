/**
 * 
 */
package com.test.reflect.demo4;

/**
 * @author LiuYanliang
 */
public class UserDaoImpl implements UserDao {

	@Override
	public boolean login() {
		System.out.println("登录功能");
		return false;
	}

	@Override
	public void register() {
		System.out.println("注册功能");
	}

}
