package com.nio.server;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.Iterator;
import java.util.StringTokenizer;

/**
 * 클라이언트의 요청을 처리한다.
 * @author 최범균
 */
public class ClientProcessor extends Thread {
   private SocketChannelQueue channelQueue;
   private File rootDirectory;
   private Selector readSelector;
   private ByteBuffer readBuffer;
   private Charset iso8859;
   private CharsetDecoder iso8859decoder;
   private Charset euckr;
   private CharsetEncoder euckrEncoder;
   
   private ByteBuffer headerBuffer;
   
   public ClientProcessor(SocketChannelQueue channelQueue, File rootDirectory)
   throws IOException {
      this.channelQueue = channelQueue;
      this.rootDirectory = rootDirectory;
      readSelector = Selector.open();
      
      this.channelQueue.setReadSelector(readSelector);
      
      readBuffer = ByteBuffer.allocate(1024);
      
      // 캐릭터셋 관련 객체 초기화
      iso8859 = Charset.forName("iso-8859-1");
      iso8859decoder = iso8859.newDecoder();
      euckr = Charset.forName("euc-kr");
      euckrEncoder = euckr.newEncoder();
      
      initializeHeaderBuffer();
   }
   
   private void initializeHeaderBuffer() 
   throws CharacterCodingException {
      CharBuffer chars = CharBuffer.allocate(88);
      chars.put("HTTP/1.1 200 OK\n");
      chars.put("Connection: close\n");
      chars.put("Server: 자바 NIO 예제 서버\n");
      chars.put("Content-Type: text/html\n");
      chars.put("\n");
      chars.flip();
      headerBuffer = euckrEncoder.encode(chars);
   }
   
   public void run() {
      while(true) {
         try {
            processSocketChannelQueue();
            
            int numKeys = readSelector.select();
            if (numKeys > 0) {
               processRequest();
            }
         } catch (IOException e) {
            //   
         }
      }
   }
   
   private void processSocketChannelQueue() throws IOException {
      SocketChannel socketChannel = null;
      while ( (socketChannel = channelQueue.getFirst()) != null) {
         socketChannel.configureBlocking(false);
         socketChannel.register( readSelector, SelectionKey.OP_READ, new StringBuffer());
      }
   }
   
   private void processRequest() {
      Iterator iter = readSelector.selectedKeys().iterator();
      while( iter.hasNext() ) {
         SelectionKey key = (SelectionKey)iter.next();
         iter.remove();
         
         SocketChannel socketChannel = (SocketChannel)key.channel();
         
         try {
            socketChannel.read(readBuffer);
            readBuffer.flip();
            String result = iso8859decoder.decode(readBuffer).toString();
            StringBuffer requestString = (StringBuffer)key.attachment();
            requestString.append(result);
               
            readBuffer.clear();
            
            if(result.endsWith("\n\n") || result.endsWith("\r\n\r\n")) {
               completeRequest(requestString.toString(), socketChannel);
            }
         } catch (IOException e) {
            // 에러 발생
         }
      }
   }
   
   private void completeRequest(String requestData, SocketChannel socketChannel) 
   throws IOException {
      StringTokenizer st = new StringTokenizer(requestData);
      st.nextToken();
      String requestURI = st.nextToken();
      System.out.println(requestURI);
      
      try {
         File file = new File(rootDirectory, requestURI);
         FileInputStream fis = new FileInputStream(file);
         FileChannel fc = fis.getChannel();
         
         int fileSize = (int)fc.size();
         ByteBuffer fileBuffer = fc.map(FileChannel.MapMode.READ_ONLY, 0, fileSize);
         
         headerBuffer.rewind();
         
         socketChannel.write(headerBuffer);
         socketChannel.write(fileBuffer);
      } catch(FileNotFoundException fnfe) {
         sendError("404", socketChannel);
      } catch (IOException e) {
         sendError("500", socketChannel);
      }
      socketChannel.close();
   }
   
   private void sendError(String errorCode, SocketChannel channel) 
   throws IOException {
      System.out.println("ClientProcessor - 클라이언트에 에러 코드 전송:"+errorCode);
      
      CharBuffer chars = CharBuffer.allocate(64);
      chars.put("HTTP/1.0 ").put(errorCode).put(" OK\n");
      chars.put("Connection: close\n");
      chars.put("Server: 자바 NIO 예제 서버\n");
      chars.put("\n");
      chars.flip();
      
      ByteBuffer buffer = euckrEncoder.encode(chars);
      channel.write(buffer);
   }
}