package com.example.demo.thread.how_to_create_thread;

/**
 *  创建线程第二种方法 实现Runable接口，充血run方法
 */
public class ThreadCreateA implements Runnable {

    @Override
    public void run() {
        System.out.println("实现runable接口");
    }

    public static void main(String[] args) {
        new Thread(new ThreadCreateA()).start();
    }
}
