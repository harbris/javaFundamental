package com.io.base;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class BufferFileCopy {

	public static void main(String[] args) {
		String file_org = "C://Users//Administrator//git//javaFundermental//src//com//io//base//test.txt";
		String file_dest = "C://Users//Administrator//git//javaFundermental//src//com//io//base//test_dest.txt";


		FileReader fr = null;
		BufferedReader br = null;
		FileWriter fw = null;
		BufferedWriter bw = null;
		try{
			fr = new FileReader(file_org);
			br = new BufferedReader(fr);
			fw = new FileWriter(file_dest);
			bw = new BufferedWriter(fw);
			
			char[] buffer = new char[512];
			int readcount = 0;
			while((readcount = br.read(buffer)) != -1){
				bw.write(buffer,0,readcount);
			}
			System.out.println("파일을 복사하였습니다.");
		}catch(Exception ex){
			System.out.println(ex);
		}finally{
			try{
				br.close();
				bw.close();
			}catch(Exception e){}
		}
		
	}
}
