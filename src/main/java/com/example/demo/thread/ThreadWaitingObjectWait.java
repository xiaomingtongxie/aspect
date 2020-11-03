package com.example.demo.thread;

public class ThreadWaitingObjectWait extends Thread {

    private byte[] lock = new byte[0];

    public ThreadWaitingObjectWait(byte[] lock) {
        this.lock = lock;
    }

    @Override
    public void run() {

        synchronized (lock) {
            try {
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        byte[] lock = new byte[0];
        ThreadWaitingObjectWait waitingObjectWait = new ThreadWaitingObjectWait(lock);
        waitingObjectWait.start();
        Thread.sleep(100);

        System.out.println("waitingObjectWait wait.start(): " + waitingObjectWait.getState());

        synchronized (lock) {
            lock.notify();
        }
        Thread.sleep(100);
        System.out.println("waitingObjectWait lock.notify() :" + waitingObjectWait.getState());
    }
}
