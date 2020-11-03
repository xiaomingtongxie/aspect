package com.example.demo.thread;

public class ThreadTimedWaitingObjectWait extends Thread {
    private byte[] lock = new byte[0];

    public ThreadTimedWaitingObjectWait(byte[] lock) {
        this.lock = lock;
    }

    @Override
    public void run() {


        synchronized (lock) {
            // 其它使线程进入timedWaiting
            // Thread.join(long)
            //LockSupport.parkNanos()
            //LockSupport.parkUntil()
            try {
                lock.wait(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        byte[] lock = new byte[0];
        ThreadTimedWaitingObjectWait timedWaitingObjectWait = new ThreadTimedWaitingObjectWait(lock);
        timedWaitingObjectWait.start();
        Thread.sleep(100);

        System.out.println("timedWaitingObjectWait wait.start(): " + timedWaitingObjectWait.getState());

        Thread.sleep(2000);
        System.out.println("timedWaitingObjectWait after sleep(20000) :" + timedWaitingObjectWait.getState());
    }
}
