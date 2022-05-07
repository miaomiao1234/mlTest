package com.example.mlTest.nio.demo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * @author miaoliang
 * @since 5/4/22 11:01 PM
 */
public class NIOServer {

    private Selector selector;

    private int port;

    private InetSocketAddress address;

    public NIOServer(int port) {
        try {
            this.port = port;
            address = new InetSocketAddress(this.port);
            // 开启通道
            ServerSocketChannel server = ServerSocketChannel.open();
            server.bind(address);
            // 默认为 阻塞, 需要手动设置为非阻塞
            server.configureBlocking(false);
            // 开启 轮训器
            selector = Selector.open();
            // Option 的简称
            server.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("服务器准备就绪，监听端口是： "+ this.port);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void listen() {
        // 轮训
        try {
            while (true) {
                int wait = this.selector.select();
                if (wait == 0) continue;
                Set<SelectionKey> keys = this.selector.selectedKeys();
                Iterator<SelectionKey> iterator = keys.iterator();
                while (iterator.hasNext()) {
                    SelectionKey next = iterator.next();
                    process(next);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void process(SelectionKey next) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        if (next.isAcceptable()) {
            ServerSocketChannel server = (ServerSocketChannel)next.channel();
            SocketChannel client = server.accept();
            client.configureBlocking(false);
            client.register(selector, SelectionKey.OP_READ);
        } else if (next.isReadable()) {
            SocketChannel client = (SocketChannel) next.channel();
            int len = client.read(buffer);
            if (len > 0) {
                buffer.flip();
                String content = new String(buffer.array(), 0, len);
                System.out.println(content);
                buffer.clear();
            }
        } else if (next.isWritable()) {
            SocketChannel client = (SocketChannel) next.channel();
            client.write(buffer.wrap("Hello Wold".getBytes()));
            client.close();
        }
    }

    public static void main(String[] args) {
        new NIOServer(8080).listen();
    }
}
