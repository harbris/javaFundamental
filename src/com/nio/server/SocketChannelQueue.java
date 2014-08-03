package com.nio.server;

import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.LinkedList;


public class SocketChannelQueue {
        
        private LinkedList list = new LinkedList();
        private Selector readSelector;
        
        SocketChannelQueue() {
        }
        
        public void setReadSelector(Selector readSelector) {
                this.readSelector = readSelector;
        }
        
        public void addLast(SocketChannel channel) {
                list.addLast(channel);
                readSelector.wakeup();
        }
        
        public SocketChannel getFirst() {
                if (list.size() == 0) return null;
                
                return (SocketChannel)list.removeFirst();
        }
}
