package com.example.demo.thread.thread_bishi;

import com.example.demo.spring.beanlifecycle.B;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.LockSupport;

public class TestPrint12 {

   static Thread A=null,B = null;


    CountDownLatch cdl = new CountDownLatch(2);


    public static void main(String[] args) {

         A = new Thread(
                ()->{

                    while (true){
                        LockSupport.unpark(B);
                        System.out.print("1");
                        LockSupport.park();
                    }


                }
        );

        B = new Thread(
                ()->{

                    while (true){
                        LockSupport.park();
                        System.out.print("2");
                        LockSupport.unpark(A);
                    }
                }
        );



        A.start();
        B.start();
    }
}
