package com.test.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;

/**
 * 需要理解用户态空间（User Space）和内核态空间（Kernel Space），
 * 这是操作系统层面的基本概念，操作系统内核、硬件驱动等运行在内核态空间，具有相对高的特权；
 * 而用户态空间，则是给普通应用和服务使用
 */
public class TestCopyFile {

	/**
	 * 利用 java.io类库，直接为源文件构建一个 FileInputStream读取，然后再为目标文件构建一个 FileOutputStream，完成写入工作。
	 * 当我们使用输入输出流进行读写时，实际上是进行了多次上下文切换，
	 * 比如应用读取数据时，先在内核态将数据从磁盘读取到内核缓存，再切换到用户态将数据从内核缓存读取到用户缓存。
	 * 所以，这种方式会带来一定的额外开销，可能会降低 IO效率
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
	 * 基于 NIO transferTo 的实现方式，在 Linux 和 Unix 上，则会使用到零拷贝技术，数据传输并不需要用户态参与，
	 * 省去了上下文切换的开销和不必要的内存拷贝，进而可能提高应用拷贝性能。
	 * 注意，transferTo 不仅仅是可以用在文件拷贝中，
	 * 与其类似的，例如读取磁盘文件，然后进行 Socket 发送，同样可以享受这种机制带来的性能和扩展性提高。
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
