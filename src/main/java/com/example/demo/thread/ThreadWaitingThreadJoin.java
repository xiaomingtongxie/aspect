package com.example.demo.thread;

import org.jetbrains.annotations.NotNull;

public class ThreadWaitingThreadJoin extends Thread {

    private Thread thread = new Thread();

    public ThreadWaitingThreadJoin(Thread thread) {
        this.thread = thread;
    }

    @Override
    public void run() {
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        byte[] lock = new byte[0];
        ThreadNewRunable threadNewRunable = new ThreadNewRunable(lock);
        threadNewRunable.start();
        ThreadWaitingThreadJoin threadWaitingThreadJoin = new ThreadWaitingThreadJoin(threadNewRunable);
        threadWaitingThreadJoin.start();
        Thread.sleep(100);
        System.out.println("threadWaitingThreadJoin.join() : " + threadWaitingThreadJoin.getState());
    }
}
