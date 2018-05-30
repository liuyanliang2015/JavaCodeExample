package com.test.jvm.myClassLoader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MyClassLoader extends ClassLoader {
	private String path;// 记载类的路径
	private String name;// 类记载器名称

	public MyClassLoader(String name, String path) {
		super();// 让系统类加载器成为该类的父类
		this.name = name;
		this.path = path;
	}

	public MyClassLoader(ClassLoader parent, String name, String path) {
		super(parent);// 显式指定父加载器
		this.name = name;
		this.path = path;
	}

	/**
	 * 加载自定义类 例如: name="com.test.Demo"
	 */
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		byte[] data = readClassFileToByteArray(name);
		return this.defineClass(name, data, 0, data.length);
	}

	/**
	 * 获取class文件的字节数组
	 * 
	 * @param name
	 * @return
	 */
	private byte[] readClassFileToByteArray(String name) {
		InputStream is = null;
		byte[] returnData = null;
		// linux环境File.separator
		name = name.replaceAll("\\.", "/");
		String filePath = this.path + name + ".class";
		File file = new File(filePath);

		ByteArrayOutputStream os = new ByteArrayOutputStream();
		try {
			is = new FileInputStream(file);
			int tmp = 0;
			while ((tmp = is.read()) != -1) {
				os.write(tmp);
			}
			returnData = os.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (is != null) {
					is.close();
				}
				
				if (os != null) {
					os.close();
				}
			} catch (IOException e) {
				e.printStackTrace();

			}
		}

		return returnData;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
