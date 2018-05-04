/**
 * 
 */
package com.test;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.Properties;
import java.util.Set;

/**
 * public void load(Reader reader):把文件中的数据读取到集合中
 * public void store(Writer writer,String comments):把集合中的数据存储到文件
 */
public class PropertiesDemo {
	public static void main(String[] args) throws Exception {
		myStore();
		myLoad();
	}

	/**
	 * Properties写文件
	 * @throws Exception
	 */
	private static void myStore() throws Exception {
		Properties prop = new Properties();
		prop.setProperty("lingqingxia", "35");
		Writer reader = new FileWriter("prop.txt");
		prop.store(reader,"my love");
	}
	
	
	/**
	 * Properties读文件
	 * @throws Exception
	 */
	private static void myLoad() throws Exception {
		Properties prop = new Properties();
		Reader reader = new FileReader("prop.txt");
		prop.load(reader);
		Set<String> keys = prop.stringPropertyNames();
		for (String key : keys) {
			System.out.println(key + "->" + prop.getProperty(key));
		}
	}

}
