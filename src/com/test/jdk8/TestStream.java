package com.test.jdk8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

public class TestStream {
	
	@Test
	public void testStream1(){
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.forEach(e -> {
			e = e + "-temp";
			System.out.println(e);
		});
		
		System.out.println(list.toString());
	}

	@Test
	public void testStream2(){
		List<String> list = new ArrayList<String>();
		list.add("a");
		List<String> list2 = list.stream().map((x) -> {
			try {
				x = x + "-temp";
				System.out.println(x);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			return x;
		}).collect(Collectors.toList());
		
		System.out.println(list2.toString());
	}

}
