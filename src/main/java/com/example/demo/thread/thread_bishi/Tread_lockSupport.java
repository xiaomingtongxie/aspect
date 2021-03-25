package com.example.demo.thread.thread_bishi;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * 淘宝面试题： 实现一个容器，提供两个方法add 、size ,写两个线程
 * <p>
 * 线程1： 添加10个元素到容器中 locksuport.park unpark，该方法还有问题
 * <p>
 * 线程2： 实时监控元素个数，当个数到5个时，线程2给出提示并结束
 */
public class Tread_lockSupport {
    volatile List THREAD_LIST = new ArrayList();

    public void add(Object o) {
        THREAD_LIST.add(o);
    }

    public int size() {
        return THREAD_LIST.size();
    }

    public static void main(String[] args) {

        Tread_lockSupport treadAddAndSize = new Tread_lockSupport();

        final Thread t1, t2;


        t2 = new Thread(() -> {
            System.out.println("t2 启动");
            if (treadAddAndSize.size() != 5) {
                // 线程2阻塞
                LockSupport.park();
            }
            System.out.println("thread2: 结束,当前容器大小：" + treadAddAndSize.size());
            // 通知t1继续执行
        });
        t2.start();
//        try {
//            TimeUnit.SECONDS.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }


        t1 = new Thread(
                () -> {
                    System.out.println("线程1 启动");
                    for (int i = 1; i <= 10; i++) {
                        treadAddAndSize.add(new Object());
                        System.out.println("tread1: add： " + i);

                        if (treadAddAndSize.size() == 5) {
                            // 因为门闩数量是1 ，这里countDown一次就放开了,就是唤醒线程2的意思
                            LockSupport.unpark(t2);
                            // 唤醒线程2之后再阻塞线程1呗
                            LockSupport.park();
                        }
                    }
//                    try {
//                        TimeUnit.SECONDS.sleep(1);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }

                }
        );
        t1.start();
    }
}
