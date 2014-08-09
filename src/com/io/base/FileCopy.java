package com.io.base;

import java.io.FileReader;
import java.io.FileWriter;

public class FileCopy {

	public static void main(String[] args) {
		String file_org = "C://Users//Administrator//git//javaFundermental//src//com//io//base//test.txt";
		String file_dest = "C://Users//Administrator//git//javaFundermental//src//com//io//base//test_dest.txt";


		FileReader fr = null;
		FileWriter fw = null;
		try{
			fr = new FileReader(file_org);
			fw = new FileWriter(file_dest);
			char[] buffer = new char[512];
			int readcount = 0;
			while((readcount = fr.read(buffer)) != -1){
				fw.write(buffer,0,readcount);
			}
			System.out.println("파일을 복사하였습니다.");
		}catch(Exception ex){
			System.out.println(ex);
		}finally{
			try{
				fr.close();
				fw.close();
			}catch(Exception e){}
		}
		
	}
}
