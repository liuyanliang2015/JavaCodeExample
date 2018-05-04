/**
 * 
 */
package com.test.model.decorate;

/**
 * @author LiuYanliang
 *
 */
public class GamePhoneDecorate extends PhoneDecorate{

	public GamePhoneDecorate(Phone p) {
		super(p);
	}
	
	@Override
	public void call() {
		super.call();
		System.out.println("ÕÊ”Œœ∑");
	}

}
