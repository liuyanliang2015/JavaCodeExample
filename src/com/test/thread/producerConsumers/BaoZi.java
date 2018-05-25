/**
 * 
 */
package com.test.thread.producerConsumers;

/**
 * 包子对象
 */
public class BaoZi {
	private String name;
	private float price;
	 boolean flag = false; //默认false

	public BaoZi() {

	}

	/**
	 * @param name
	 * @param price
	 */
	public BaoZi(String name, float price) {
		super();
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	/**
	 * @return the flag
	 */
	public boolean isFlag() {
		return flag;
	}

	/**
	 * @param flag the flag to set
	 */
	public void setFlag(boolean flag) {
		this.flag = flag;
	}

}
