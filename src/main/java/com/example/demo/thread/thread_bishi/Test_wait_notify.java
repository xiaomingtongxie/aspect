package com.example.demo.thread.thread_bishi;

/**
 *  测试一下 wait notify
 */
public class Test_wait_notify {

    public static void main(String[] args) {

        final Object lock = new Object();

        new Thread(
                ()->{
                    synchronized (lock){
                        System.out.println(" 线程1 启动，上锁");
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
        ,"t1").start();
        // 这里会抛异常  wait notify 源码需要看下
        lock.notify();
        System.out.println(" 唤醒等待线程 ");
    }
}
