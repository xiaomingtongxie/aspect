package com.example.demo.thread;

import kotlin.jvm.Synchronized;

/**
 * 线程状态转换演示
 */
public class ThreadStatu extends Thread {

    private byte[] lock = new byte[0];

    public ThreadStatu(byte[] lock) {
        this.lock = lock;
    }

    @Override
    public void run() {

        synchronized (lock) {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("test lock status");
        }
    }

    public static void main(String[] args) throws InterruptedException {


        byte[] lock = new byte[0];
        ThreadStatu threadStatu = new ThreadStatu(lock);
        System.out.println("threadStatu-new ：" + threadStatu.getState());

        threadStatu.start();
        System.out.println("threadStatus-start：" + threadStatu.getState());

        ThreadStatu threadStatu1 = new ThreadStatu(lock);
        threadStatu1.start();


        Thread.sleep(1000);

        System.out.println("threadStatu1-blocked : " + threadStatu1.getState());
    }

}
