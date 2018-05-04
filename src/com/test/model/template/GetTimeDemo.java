/**
 * 
 */
package com.test.model.template;


/**
 * @author LiuYanliang
 */
public class GetTimeDemo extends GetTime{

	@Override
	public void code() {
		for(int i = 0;i < 10000;i++){
			System.out.println(i);
		}
	}
	
	
	public static void main(String[] args) {
		GetTimeDemo d = new GetTimeDemo();
		long time = d.getTime();
		System.out.println("cost time:"+time);
	}

}
