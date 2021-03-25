package com.example.demo.thread.thread_bishi;

import java.lang.ref.SoftReference;

/**
 * 测试一下软引用
 *
 * 内存不够用的时候 被回收
 */
public class Test_softReference {

    public static void main(String[] args) {
        SoftReference<byte[]> s = new SoftReference<>(new byte[1024 * 1024 * 10]);
        System.out.println(s.get());

        System.gc();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(s.get());

        // 再分配一个数组，heap将装不下，这个时候系统会垃圾回收，先回收一次，如果不够，则会把软引用干掉
        // 这里说一下： 设置Jvm 参数 -Xms20M -Xmx20M
        byte[] b = new byte[1024*1024*6];
        System.out.println(s.get());


    }


}
