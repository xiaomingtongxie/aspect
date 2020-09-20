package com.example.demo.spring.beanlifecycle;

import org.springframework.stereotype.Component;

@Component
public class B {
    public B() {
        System.out.println("create B.");
    }
}
