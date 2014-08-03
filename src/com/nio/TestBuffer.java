package com.nio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import junit.framework.TestCase;

public class TestBuffer  extends TestCase{
	
	/*public void test1() throws IOException {
	      FileWriter wr = new FileWriter("c:\\test1.txt");
	      
	      int count =10000000;
	      while(count > 0){
	    	  wr.write(count);//("aaa"+count+" \n");
	    	  count --;
	      }
	      wr.close();
	   }
	
	public void test2() throws IOException {
		BufferedWriter wr = new BufferedWriter(new FileWriter("c:\\test2.txt"));
	      int count =10000000;
	      while(count > 0){
	    	  wr.write("aaa"+count+" \n");
	    	  count --;
	      }
	      wr.close();
	   }*/
	
	/*public void test3() throws IOException {
		   
	    FileInputStream fis = null;
	    FileOutputStream fos = null;
		try {
		      fis = new FileInputStream("c:\\test2.txt");
		      fos = new FileOutputStream("c:\\test3.txt");
		      byte[] buffer = new byte[512];
		      int readcount = 0;
		   
		      while((readcount=fis.read(buffer)) != -1) {
		        fos.write(buffer, 0, readcount);
		      }
		      System.out.println("File Copy Completed.");
		    } catch(Exception ex) {
		      System.out.println(ex);
		    } finally {
		      try {
		        fis.close();
		      } catch (IOException ex) {}
		      try {
		        fos.close();
		      } catch (IOException ex) {}
		    }
		  }
	*/
	/*public void test4() throws IOException {

	    FileReader fr = null;
	    BufferedReader br = null;
	    FileWriter fw = null;
	    BufferedWriter bw = null;
	    try {
	      fr = new FileReader("c:\\test2.txt");
	      br = new BufferedReader(fr);
	      fw = new FileWriter("c:\\test4.txt");
	      bw = new BufferedWriter(fw);
	   
	      char[] buffer = new char[512];
	      int readcount = 0;
	      while((readcount = br.read(buffer)) != -1) {
	        bw.write(buffer, 0, readcount);
	      }
	      bw.write(br.readLine());
	      System.out.println("파일을 복사하였습니다.");
	    } catch(Exception ex) {
	      System.out.println(ex);
	    } finally {
	      try {
	        br.close();
	        bw.close();
	      } catch(Exception e) {}
	    }
	  }*/
	
	/*public void test5() throws IOException {

	    FileReader fr = null;
	    FileWriter fw = null;
	    try {
	      fr = new FileReader("c:\\test2.txt");
	      fw = new FileWriter("c:\\test4.txt");
	   
	      char[] buffer = new char[512];
	      int readcount = 0;
	      while((readcount = fr.read(buffer)) != -1) {
	    	  fw.write(buffer, 0, readcount);
	      }
	      fw.write(fr.read());
	      System.out.println("파일을 복사하였습니다.");
	    } catch(Exception ex) {
	      System.out.println(ex);
	    } finally {
	      try {
	    	  fr.close();
	    	  fw.close();
	      } catch(Exception e) {}
	    }
	  }
	*/
	public void test5() throws IOException {
	    FileChannel inputChannel = null;
	    FileChannel outputChannel = null;
	    try {
	        FileInputStream is = new FileInputStream("c:\\test2.txt");
	        FileOutputStream out = new FileOutputStream("c:\\test5.txt");
	        inputChannel = is.getChannel();
	        outputChannel = out.getChannel();        
	          
	        ByteBuffer buffer = ByteBuffer.allocateDirect(512);
	        int len = -1;
	        while ( (len = inputChannel.read(buffer)) != -1) {
	            if (len == 512) {
	                buffer.position(0);
	            } else {
	                buffer.flip();
	            }
	            outputChannel.write(buffer);
	            if (len == 512) {
	                buffer.rewind();
	            } else {
	                buffer.clear();
	            }
	        }
	        
	    } catch(IOException ex) {
	        //
	    } finally {
	        //
	    }
	}
	
	
}
