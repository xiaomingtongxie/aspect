package com.example.demo.thread;

public class ThreadTimedWaitingThreadSleep extends Thread {

    private byte[] lock = new byte[0];

    public ThreadTimedWaitingThreadSleep(byte[] lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        byte[] lock = new byte[0];
        ThreadTimedWaitingThreadSleep timedWaitingThreadSleep = new ThreadTimedWaitingThreadSleep(lock);
        timedWaitingThreadSleep.start();
        Thread.sleep(100);
        System.out.println("timedWaitingThreadSleep Thread.sleep(long) : " + timedWaitingThreadSleep.getState());
    }
}
