package com.example.demo.thread.thread_bishi;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.LockSupport;

/**
 * 淘宝面试题： 实现一个容器，提供两个方法add 、size ,写两个线程
 * <p>
 * 线程1： 添加10个元素到容器中 locksuport.park unpark，该方法还有问题
 * <p>
 * 线程2： 实时监控元素个数，当个数到5个时，线程2给出提示并结束
 */
public class Tread_semaphore {
    volatile List THREAD_LIST = new ArrayList();

    public void add(Object o) {
        THREAD_LIST.add(o);
    }

    public int size() {
        return THREAD_LIST.size();
    }

    static Thread t1 = null, t2 = null;

    public static void main(String[] args) {

        Tread_semaphore treadAddAndSize = new Tread_semaphore();

        Semaphore semaphore = new Semaphore(1);


        t1 = new Thread(() -> {
            System.out.println("t1 启动");

            try {
                semaphore.acquire();
                for (int i = 0; i < 5; i++) {
                    treadAddAndSize.add(new Object());
                    System.out.println("add " + i);
                }
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 通知t1继续执行

        try {
            t2.start();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            semaphore.acquire();
            for (int i = 5; i< 10;i++){
                treadAddAndSize.add(new Object());
                System.out.println("add " + i);
            }
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        },"t1");

        t2 = new Thread(
                () -> {
                    try {
                        semaphore.acquire();
                        System.out.println("t2 结束");
                        semaphore.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                },"t2"
        );
        t1.start();
    }
}
