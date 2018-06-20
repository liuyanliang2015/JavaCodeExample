package com.test.jdk8;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class TestLamda {
	
	@Test
	public void testFor(){
		List<String> list = Arrays.asList( "a", "b", "d" );
		for(String s : list){
			System.out.println(s);
		}
	}
	
	@Test
	public void testLamda1(){
		Arrays.asList( "a", "b", "d" ).forEach(e -> System.out.println(e));
		System.out.println("---------");
		Arrays.asList( "a", "b", "d" ).forEach((String e) -> System.out.println(e));
	}
	

	//Lambda表达式执行复杂语句块
	@Test
	public void testLamda2(){
		Arrays.asList( "a", "b", "d" ).forEach((String e) -> {
			System.out.println(e);
			System.out.println("执行循环："+ e);
		});
	}

	
	//Lambda表达式可以引用类成员和局部变量（会将这些变量隐式得转换成final的）
    //final String separator = ",";
	@Test
	public void testLamda3(){
		String separator = ",";
		Arrays.asList( "a", "b", "d" ).forEach((String e) -> {
			System.out.print(e + separator);
		});
	}
	
	
	@Test
	public void testLamda(){
		 // old way:
	    Runnable oldRunnable = new Runnable() {
	        @Override
	        public void run() {
	            System.out.println(Thread.currentThread().getName() + ": Old Runnable");
	        }
	    };
	    
	    // new way:
	    Runnable newRunnable = () -> {
	        System.out.println(Thread.currentThread().getName() + ": New Lambda Runnable");
	    };
	    
	    new Thread(oldRunnable).start();
	    new Thread(newRunnable).start();
	}
	
}
