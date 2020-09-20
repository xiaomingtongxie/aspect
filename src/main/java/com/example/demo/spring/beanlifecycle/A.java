package com.example.demo.spring.beanlifecycle;

import org.springframework.stereotype.Component;

@Component
public class A {

    public A() {
        System.out.println("create a.");
    }
}
