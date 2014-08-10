package com.io.base;

import java.net.*;				
import java.io.*;				
				
public class SimpleWebServer {				
	public static void main(String[] args) {			
		try{		
			ServerSocket ss = new ServerSocket(80);	
			while(true){	
				System.out.println("������ ����մϴ�.");
				Socket sock = ss.accept();
				System.out.println("���ο� �����带 �����մϴ�.");
				HttpThread ht = new HttpThread(sock);
				ht.start();
			} // while	
		}catch(Exception ex){		
			System.out.println(ex);	
		}	
	} // main		
} // class			
			
class HttpThread extends Thread{			
	private Socket sock = null;		
	BufferedReader br = null;		
	PrintWriter pw = null;		
	public HttpThread(Socket sock){		
		this.sock = sock;	
		try{	
			br = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			pw = new PrintWriter(new OutputStreamWriter(sock.getOutputStream()));
		}catch(Exception ex){	
			System.out.println(ex);
		}	
	}			
	public void run(){			
		BufferedReader fbr = null;		
		try{		
			String line = br.readLine();	
			int start = line.indexOf(" ") + 2;	
			int end = line.lastIndexOf("HTTP") -1;	
			String filename = line.substring(start, end);	
			if(filename.equals(""))	
				filename = "index.html";
			System.out.println("����ڰ� " + filename + "�� ��û�Ͽ����ϴ�.");	
			fbr = new BufferedReader(new FileReader(filename));	
			String fline = null;	
			while((fline = fbr.readLine()) != null){	
				pw.println(fline);
				pw.flush();
			}	
		}catch(Exception ex){		
			System.out.println(ex);	
		}finally{		
			try{	
				if(fbr != null) fbr.close();
			}catch(Exception ex){}	
			try{	
				if(br != null) br.close();
			}catch(Exception ex){}	
			try{	
				if(pw != null) pw.close();
			}catch(Exception ex){}	
			try{	
				if(sock != null) sock.close();
			}catch(Exception ex){}	
		} // finally
	} // run	
}		
