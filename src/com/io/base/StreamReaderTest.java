package com.io.base;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class StreamReaderTest {

	public static void main(String[] args) {
		String file = "C://Users//Administrator//git//javaFundermental//src//com//io//base//test.txt";
		
		FileInputStream fis = null;
		InputStreamReader isr = null;
		OutputStreamWriter osw = null;
		try{
			fis = new FileInputStream(file);
			isr = new InputStreamReader(fis);
			osw = new OutputStreamWriter(System.out);
			char[] buffer = new char[512];
			int readcount = 0;
			while((readcount = isr.read(buffer)) != -1){
				osw.write(buffer,0,readcount);
			}
		}catch(Exception ex){
			System.out.println(ex);
		}finally{
			try{
				fis.close();
				isr.close();
				osw.close();
			}catch(Exception e){}
		}
		
	}
}
