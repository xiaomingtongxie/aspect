package com.example.demo.thread.how_to_create_thread;

/**
 * 创建线程的方法1： 继承Thread 类，并实现Run方法
 */
public class ThreadCreate extends Thread {
    @Override
    public void run() {
        System.out.println("我是一个run方法");
    }


    public static void main(String[] args) {

//        new ThreadCreate().run();
        new ThreadCreate().start();
    }
}
