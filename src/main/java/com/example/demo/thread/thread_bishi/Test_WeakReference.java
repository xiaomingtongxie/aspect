package com.example.demo.thread.thread_bishi;

import com.example.demo.AspectBean;

import java.lang.ref.WeakReference;

/**
 *  测试弱引用 只要遭遇 gc 就被回收
 */
public class Test_WeakReference {

    public static void main(String[] args) {
//        WeakReference<AspectBean> w = new WeakReference<>(new AspectBean());
//
//        System.out.println(w.get());
//        System.gc();
//        // 经理过gc之后，这里便拿不到对象的值了
//        System.out.println(w.get());


        ThreadLocal<AspectBean> local = new ThreadLocal<>();
        local.set(new AspectBean());
        local.remove();
    }
}
