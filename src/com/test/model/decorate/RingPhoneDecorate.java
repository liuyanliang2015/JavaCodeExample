/**
 * 
 */
package com.test.model.decorate;

/**
 * @author LiuYanliang
 *
 */
public class RingPhoneDecorate extends PhoneDecorate {

	public RingPhoneDecorate(Phone p) {
		super(p);
	}
	
	@Override
	public void call() {
		System.out.println("听彩铃");
		super.call();
	}

}
