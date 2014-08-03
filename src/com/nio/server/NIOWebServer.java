package com.nio.server;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;


public class NIOWebServer extends Thread {
        
        private File rootDirectory;
        private int port;
        
        public NIOWebServer(String documentRoot, int port) {
                rootDirectory = new File(documentRoot);
                
                if (!rootDirectory.isDirectory())
                        throw new IllegalArgumentException("a"+documentRoot);
                if (!rootDirectory.canRead())
                        throw new IllegalArgumentException("b"+documentRoot);
                
                if (port < 1) throw new IllegalArgumentException("c"+port);
                
                this.port = port;
        }
        
        public void run() {
                LinkedList socketQueue = new LinkedList();
                ClientAcceptor acceptor = null;
                ClientProcessor processor = null;
                
                try {
                        SocketChannelQueue channelQueue = new SocketChannelQueue();
                        
                        processor = new ClientProcessor(channelQueue, rootDirectory);
                        acceptor = new ClientAcceptor(channelQueue, port);
                } catch (IOException e) {
                        e.printStackTrace();
                        return ;
                }
                
                acceptor.start();
                processor.start();
        }
        
        public static void main(String[] args) {
               
                String documentRoot = "C:\\";
                int port = 80;
                if (args.length > 1) {
                        port = Integer.parseInt("80");
                }
                NIOWebServer webServer = new NIOWebServer(documentRoot, port);
                webServer.start();
        }
        
        public static void printUsage() {
                System.out.println("java madvirus.nioexam.NIOWebServer [documentRoot] [port]");
        }
}
