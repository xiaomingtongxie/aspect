package com.example.demo.thread;

import java.util.concurrent.locks.LockSupport;

public class ThreadWaitingPark extends Thread {

    private byte[] lock = new byte[0];

    public ThreadWaitingPark(byte[] lock) {
        this.lock = lock;
    }

    @Override
    public void run() {

            // 以下三种均可使线程进入waiting状态
//                Object.wait();
//                Thread.join();;
            LockSupport.park();

    }

    public static void main(String[] args) throws InterruptedException {
        byte[] lock = new byte[0];
        ThreadWaitingPark threadWaitingPark = new ThreadWaitingPark(lock);
        threadWaitingPark.start();
        Thread.sleep(1000);
        System.out.println("threadWaiting-Waiting-when LockSupport.park() : " + threadWaitingPark.getState());
        LockSupport.unpark(threadWaitingPark);
        Thread.sleep(1000);
        System.out.println("threadWaiting-Waiting-when LockSupport.unpark(thread)  : " + threadWaitingPark.getState());


    }
}
