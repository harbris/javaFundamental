package com.nio.base;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class AsynchFile {

	public static void main(String[] args) throws InterruptedException, ExecutionException{
		ByteBuffer buffer = ByteBuffer.allocate(100);
		String encoding = System.getProperty("file.encoding");
		
		Path path = Paths.get("C://Users//Administrator//git//javaFundermental//src//com//nio//base//", "test.txt");
		
		try(AsynchronousFileChannel asynchronousFileChannel = AsynchronousFileChannel.open(path,StandardOpenOption.READ)){
			Future<Integer> result = asynchronousFileChannel.read(buffer, 0);
			
			while(!result.isDone()){
				System.out.println("Do something else while reading...");
			}
			
			System.out.println("Read done: " +result.isDone());
			System.out.println("Bytes read: " + result.get());
			
		} catch (IOException ex) {
			System.err.print(ex);
		}
		
		buffer.flip();
		System.out.print(Charset.forName(encoding).decode(buffer));
		buffer.clear();
	}
}
