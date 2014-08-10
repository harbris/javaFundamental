package com.nio.base;
import java.io.*;

public class SmallBuffer {
	public static void main(String[] args) {
		String file_org = "C://Users//Administrator//git//javaFundermental//src//com//nio//base//test.txt";
		String file_dest = "C://Users//Administrator//git//javaFundermental//src//com//nio//base//test_dest.txt";

		SmallBuffer io = new SmallBuffer();
		try {
			long startTime = System.currentTimeMillis();
			io.copy(file_org, file_dest);            
			long endTime = System.currentTimeMillis();
			System.out.println("SmallBuffer ó���ð� : " + (endTime - startTime) + " milli seconds" );
		} catch (IOException e) { 
			e.printStackTrace();
		}
	}

	public static void copy(String fileFrom, String fileTo) throws IOException {
		InputStream inBuffer = null;
		OutputStream outBuffer = null;
		try {
			// ������ �а� �� �� 2048byte �� ũ�⸦ ���� ���۽�Ʈ������ ���۸��� �ϸ鼭 ���� ���縦 ��.
			InputStream in = new FileInputStream(fileFrom);
			inBuffer = new BufferedInputStream(in, 2048);
			OutputStream out = new FileOutputStream(fileTo);
			outBuffer = new BufferedOutputStream(out , 2048);
			while (true) {
				int bytedata = inBuffer.read();
				if (bytedata == -1)
					break;
				out.write(bytedata);
			}
		} finally {
			if (inBuffer != null)
				inBuffer.close();
			if (outBuffer !=null)
				outBuffer.close();
		}
	} 
}
