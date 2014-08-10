package com.io.base;

import java.net.*;				
import java.io.*;				
public class SimpleWebServerBasic {				
				
	public static void main(String[] args) {			
		Socket sock = null;		
		BufferedReader br = null;
		PrintWriter pw = null;		
		try{		
			ServerSocket ss = new ServerSocket(80);	
			sock = ss.accept();	
			br = new BufferedReader(new InputStreamReader(sock.getInputStream()));	
			pw = new PrintWriter(new OutputStreamWriter(sock.getOutputStream()));
			String line = null;	
			//while((line = br.readLine()) != null){	
				System.out.println(line);
			pw.println("aaa");
			pw.flush();
			//}
			
			pw.close();	
			br.close();	
			sock.close();	
		}catch(Exception ex){		
			System.out.println(ex);	
		}finally{		
			try{	
				if(br != null) br.close();
			}catch(Exception ex){}	
			try{	
				if(sock != null) sock.close();
			}catch(Exception ex){}	
		} // finally		
	}			
}				
