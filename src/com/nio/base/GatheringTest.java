package com.nio.base;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.GatheringByteChannel;

public class GatheringTest {

	public static void main(String[] args) throws IOException {
		FileOutputStream fo = new FileOutputStream("C://Users//Administrator//git//javaFundermental//src//com//nio//base//test.txt");
		GatheringByteChannel channel = fo.getChannel();

		ByteBuffer header = ByteBuffer.allocateDirect(20);
		ByteBuffer body = ByteBuffer.allocateDirect(40);
		ByteBuffer[] buffers = { header, body };
		
		header.put("Hello ".getBytes());
		body.put("World!".getBytes());
		
		header.flip();
		body.flip();
		
		channel.write(buffers);
		channel.close();
	}
}
