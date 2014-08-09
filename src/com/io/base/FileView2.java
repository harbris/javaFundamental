package com.io.base;

import java.io.FileInputStream;
import java.io.IOException;

public class FileView2 {

	public static void main(String[] args) {
		String file = "C://Users//Administrator//git//javaFundermental//src//com//io//base//test.txt";
				
		FileInputStream fis = null;
		try{
			fis = new FileInputStream(file);
			int readcount = 0;
			byte[] buffer = new byte[512];
			while((readcount = fis.read(buffer)) != -1){
				System.out.write(buffer, 0, readcount);
			}
		}catch(Exception ex){
			System.out.println(ex);
		}finally{
			try {
				fis.close();
			} catch (IOException e) {}
		}
	} // main
}
