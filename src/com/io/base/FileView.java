package com.io.base;

import java.io.FileInputStream;
import java.io.IOException;

public class FileView {

	public static void main(String[] args) {
		String file = "C://Users//Administrator//git//javaFundermental//src//com//io//base//test.txt";
				
		FileInputStream fis = null;
		try{
			fis = new FileInputStream(file);
			int i = 0;
			while((i = fis.read()) != -1){
				System.out.write(i);
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
