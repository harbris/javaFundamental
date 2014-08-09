package com.io.nio.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * Ŭ���̾�Ʈ�� ������ ����Ѵ�.
 * @author �ֹ���
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
      // ������ ��Ʈ�� �������� ���ε�
      InetSocketAddress address = new InetSocketAddress(port);
      ssc.socket().bind(address);         
      ssc.register(acceptSelector, SelectionKey.OP_ACCEPT);
   }
   
   public void run() {
      try {
         while(true) {
        	// selector�� ���õ� �̺�Ʈ�� �߻��Ҷ����� ��ŷ!
            int numKeys = acceptSelector.select();
            if (numKeys > 0) {
               Iterator iter = acceptSelector.selectedKeys().iterator();
               
               while(iter.hasNext()) {
                  SelectionKey key = (SelectionKey)iter.next();
                  iter.remove();
                  
                  ServerSocketChannel readyChannel = 
                       (ServerSocketChannel)key.channel();
                  SocketChannel incomingChannel = readyChannel.accept();
                  
                  System.out.println("ClientAcceptor - Ŭ���̾�Ʈ �����!");
                  
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