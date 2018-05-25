/**
 * 
 */
package com.test.model.decorate;

/**
 * @author LiuYanliang
 *
 */
public class Test {
	public static void main(String[] args) {
		Phone p = new Iphone();
		PhoneDecorate pd  = new RingPhoneDecorate(new GamePhoneDecorate(p));
		pd.call();
		
	}

}
