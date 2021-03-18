package com.example.demo.thread.thread_bishi;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * 淘宝面试题： 实现一个容器，提供两个方法add 、size ,写两个线程
 * <p>
 * 线程1： 添加10个元素到容器中
 * <p>
 * 线程2： 实时监控元素个数，当个数到5个时，线程2给出提示并结束
 */
public class TreadAddAndSize {
    volatile List THREAD_LIST = new ArrayList();

    public void add(Object o) {
        THREAD_LIST.add(o);
    }

    public int size() {
        return THREAD_LIST.size();
    }

    public static void main(String[] args) {

        TreadAddAndSize treadAddAndSize = new TreadAddAndSize();


        final Object lock = new Object();


        new Thread(() -> {
            synchronized (lock) {
                System.out.println("t2 启动");
                    if (treadAddAndSize.size() != 5) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
//                        break;
                    }
                        System.out.println("thread2: 结束,当前容器大小：" + treadAddAndSize.size());
            }
            // 通知t1继续执行
            lock.notify();
        }, "t2").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        new Thread(
                () -> {
                    System.out.println("线程1 启动");
                    synchronized (lock) {
                        for (int i = 1; i <= 10; i++) {
                            treadAddAndSize.add(new Object());
                            System.out.println("tread1: add： " + i);

                            if(treadAddAndSize.size() == 5){
                                lock.notify();
                                try {
                                    lock.wait();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                            try {
                                TimeUnit.SECONDS.sleep(1);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                        }
                    }
                }
                , "t1").start();


    }
}
