package com.example.demo.thread.how_to_create_thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadCtreateB {

    public static void main(String[] args) {
        // 创建线程的三种方法
        // 1 . 继承Thread 并实现run() 方法

        new ThreadCreate().start();

        // 2 . 创建线程的第二种方法： 实现Runable接口，并重写run() 方法
        // 2.1
        new Thread(new ThreadCreateA()).start();
        // 2.2 java8 写法 ，因为接口只有一个方法，所以可以按照匿名方法实现
        new Thread(
                ()->{
                    System.out.println("匿名内部类-实现");
                }
        ).start();
        // 3 . 用线程池创建线程
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程池创建的线程，可还行");
            }
        });
    }
}
