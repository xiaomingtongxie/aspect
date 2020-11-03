package com.example.demo.io.nio;

import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

public class MultiplexerNioServer {

    private ServerSocketChannel serverSocketChannel;
    private Selector selector;// 事件轮询
    private volatile boolean stop = false;


}
