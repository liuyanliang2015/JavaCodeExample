/**
 * 
 */
package com.test.model.template;

/**
 * @author LiuYanliang
 * 
 */
public abstract class GetTime {
	
	/**
	 * 模板方法：计算程序的执行时间
	 * @return
	 */
	public long getTime() {
		long start = System.currentTimeMillis();
		code();
		long end = System.currentTimeMillis();
		return (end - start);
	}

	public abstract void code();

}
