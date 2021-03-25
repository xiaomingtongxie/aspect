package com.example.demo.thread.thread_bishi;

import com.example.demo.AspectBean;

import java.lang.ref.ReferenceQueue;
import java.util.LinkedList;
import java.util.List;

/**
 * 虚引用
 * 管理堆外内存用的
 */
public class Test_PhantomReference {

    private static final List<Object>  LIST = new LinkedList<>();
    private static final ReferenceQueue<AspectBean> QUEUE = new ReferenceQueue<>();


    public static void main(String[] args) {

    }


}
