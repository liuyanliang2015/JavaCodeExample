package com.test.map;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {
	public static void main(String[] args) {
		Map<String,String>  map  = new HashMap<String,String>();
		System.out.println(map.size());
		System.out.println(1 << 4);//0
		System.out.println(1 << 30);//1073741824
		
		String value1 = map.put("z", "30");
		String value2 = map.put("z", "31");
		
		System.out.println("value1:"+value1);//null
		System.out.println("value2:"+value2);//30
		System.out.println(map.get("z"));//31
	}
}
