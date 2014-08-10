package com.nio.base;
import java.io.*;

public class NonBuffer {
	public static void main(String[] args) {
		String file_org = "C://Users//Administrator//git//javaFundermental//src//com//nio//base//test.txt";
		String file_dest = "C://Users//Administrator//git//javaFundermental//src//com//nio//base//test_dest.txt";

		NonBuffer io = new NonBuffer();
		try {
			// ���Ϻ��� ���۽ð� ���..
			long startTime = System.currentTimeMillis();
			// ���� ���� ����..
			io.copy(file_org, file_dest);   
			// ���Ϻ��� ����ð� ���..  
			long endTime = System.currentTimeMillis();
			// ������ �ð��� �󸶳� �Ǵ��� ���.
			System.out.println("NonBuffer ó���ð� : "	+ (endTime - startTime) + " milli seconds" );
		} catch (IOException e) { 
			e.printStackTrace();
		}
	}

	public static void copy(String fileFrom, String fileTo) throws IOException {
		InputStream in = null;
		OutputStream out = null;
		try {
			in = new FileInputStream(fileFrom);
			out = new FileOutputStream(fileTo);
			while (true) {
				// 1����Ʈ�� �д´�.
				int bytedata = in.read();
				// ���� EOF ��� ������ ����������.
				if (bytedata == -1)
					break;
				// �ռ� ���� 1����Ʈ�� ���Ͽ� ����.
				out.write(bytedata);
			}
		} finally {
			// finally �����ȿ��� �� ����� ��Ʈ���� �����ϰ� �ݾ��ش�.
			if (in != null)
				in.close();
			if (out !=null)
				out.close();
		}
	}
}
