package com.test.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;

public class TestCopyFile {

	
	/**
	 * 利用 java.io类库，直接为源文件构建一个 FileInputStream读取，然后再为目标文件构建一个 FileOutputStream，完成写入工作。
	 * @param source
	 * @param dest
	 * @throws IOException
	 */
	@SuppressWarnings("resource")
	public static void copyFileByStream(File source, File dest)throws IOException {
		InputStream is = new FileInputStream(source);
		OutputStream os = new FileOutputStream(dest);
		byte[] buffer = new byte[1024];
		int length;
		while ((length = is.read(buffer)) > 0) {
			os.write(buffer, 0, length);
		}
	}

	
	/**
	 * 利用 java.nio 类库提供的 transferTo 或 transferFrom 方法实现。
	 * @param source
	 * @param dest
	 * @throws IOException
	 */
	@SuppressWarnings("resource")
	public static void copyFileByChannel(File source, File dest)throws IOException {
			FileChannel sourceChannel = new FileInputStream(source).getChannel();
			FileChannel targetChannel = new FileOutputStream(dest).getChannel();
			for (long count = sourceChannel.size(); count > 0;) {
				long transferred = sourceChannel.transferTo(sourceChannel.position(), count, targetChannel);
				sourceChannel.position(sourceChannel.position() + transferred);
				count -= transferred;
			}

	}
	
	public static void main(String[] args) throws IOException {
		File source = new File("E:\\a.txt");
		File dest = new File("E:\\b.txt");
		//copyFileByStream(source, dest);
		copyFileByChannel(source, dest);
	}

}
