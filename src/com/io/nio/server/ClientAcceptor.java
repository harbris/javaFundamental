package com.io.nio.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * 클라이언트의 연결을 대기한다.
 * @author 최범균
 */
public class ClientAcceptor extends Thread {
   private int port;
   private SocketChannelQueue channelQueue;
   
   private ServerSocketChannel ssc;
   private Selector acceptSelector;
   
   public ClientAcceptor(SocketChannelQueue channelQueue, int port)
   throws IOException {
      this.port = port;
      this.channelQueue = channelQueue;
      
      acceptSelector = Selector.open();
      ssc = ServerSocketChannel.open();
      ssc.configureBlocking(true);            
      // 지정한 포트에 서버소켓 바인딩
      InetSocketAddress address = new InetSocketAddress(port);
      ssc.socket().bind(address);         
      ssc.register(acceptSelector, SelectionKey.OP_ACCEPT);
   }
   
   public void run() {
      try {
         while(true) {
        	// selector와 관련된 이벤트가 발생할때까지 블럭킹!
            int numKeys = acceptSelector.select();
            if (numKeys > 0) {
               Iterator iter = acceptSelector.selectedKeys().iterator();
               
               while(iter.hasNext()) {
                  SelectionKey key = (SelectionKey)iter.next();
                  iter.remove();
                  
                  ServerSocketChannel readyChannel = 
                       (ServerSocketChannel)key.channel();
                  SocketChannel incomingChannel = readyChannel.accept();
                  
                  System.out.println("ClientAcceptor - 클라이언트 연결됨!");
                  
                  channelQueue.addLast(incomingChannel);
               }
            }
         }
      } catch (IOException e) {
         e.printStackTrace();
      } finally {
         try { ssc.close(); } catch (IOException e1) { }
      }
   }
}