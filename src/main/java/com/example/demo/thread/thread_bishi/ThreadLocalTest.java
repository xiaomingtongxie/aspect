package com.example.demo.thread.thread_bishi;

import com.example.demo.AspectBean;

import java.util.concurrent.TimeUnit;

public class ThreadLocalTest {

    public static void main(String[] args) {

        ThreadLocal<AspectBean> threadLocal = new ThreadLocal<>();
        Thread t1 = new Thread(
                ()->{
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    // 拿不到值
                    System.out.println(threadLocal.get());

                }
        );
        t1.start();
        Thread t2 = new Thread(
                ()->{
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    threadLocal.set(new AspectBean());
                }
        );
        t2.start();
    }
}
