package com.example.demo.thread;

public class ThreadBlocked extends Thread {

    private byte[] lock = new byte[0];

    public ThreadBlocked(byte[] lock) {
        this.lock = lock;
    }

    @Override
    public void run() {

        synchronized (lock) {
            try {
                Thread.sleep(10000);// 休眠十秒，防止过快结束
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        byte[] lock = new byte[0];
        ThreadBlocked threadBlocked = new ThreadBlocked(lock);
        threadBlocked.start();
        ThreadBlocked threadBlocked1 = new ThreadBlocked(lock);
        threadBlocked1.start();
        Thread.sleep(1000);
        System.out.println("threadBlocked1-blocked : " + threadBlocked1.getState());
    }
}
