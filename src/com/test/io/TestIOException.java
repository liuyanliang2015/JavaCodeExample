/**
 * 
 */
package com.test.io;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

/**
 * 考察IO异常处理以及流关闭问题
 */
public class TestIOException {
	public static void main(String[] args) {
		FileOutputStream fos = null;
		OutputStreamWriter osw = null;
		BufferedWriter bw = null;
		try {
			fos = new FileOutputStream("c:\\a.txt");
			osw = new OutputStreamWriter(fos, "UTF-8");
			bw = new BufferedWriter(osw);
			bw.write("java IO close test");
			//考察点1:异常捕获的顺序
		} catch (FileNotFoundException e2) {
			e2.printStackTrace();
		} catch (UnsupportedEncodingException e3) {
			e3.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			try {
				//考察点2:关闭顺序不能错
				if (bw != null) {
					bw.close();
				}
				//考察点3:判断流是否为空
				if (osw != null) {
					osw.close();
				}
				if (fos != null) {
					fos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

}
