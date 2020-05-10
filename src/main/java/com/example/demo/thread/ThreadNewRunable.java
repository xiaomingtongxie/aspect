package com.example.demo.thread;

/**
 * 线程状态转换演示 NEW RUNABLE
 */
public class ThreadNewRunable extends Thread {

    private byte[] lock = new byte[0];

    public ThreadNewRunable(byte[] lock) {
        this.lock = lock;
    }

    @Override
    public void run() {

        // doNothing
//        synchronized (lock) {
//            try {
//                Thread.sleep(1000);// 休眠十秒，防止过快结束
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
    }

    public static void main(String[] args) throws InterruptedException {


        byte[] lock = new byte[0];
        ThreadNewRunable threadNewRunable = new ThreadNewRunable(lock);
        System.out.println("threadStatu-new ：" + threadNewRunable.getState());

        threadNewRunable.start();
        System.out.println("threadStatus-start：" + threadNewRunable.getState());

        ThreadNewRunable threadNewRunable1 = new ThreadNewRunable(lock);
        threadNewRunable1.start();


        Thread.sleep(1000);

        System.out.println("threadStatu1-blocked : " + threadNewRunable1.getState());
    }

}
