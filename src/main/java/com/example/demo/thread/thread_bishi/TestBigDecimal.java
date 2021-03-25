package com.example.demo.thread.thread_bishi;

import java.math.BigDecimal;

public class TestBigDecimal {

    public static void main(String[] args) {

        BigDecimal bigDecimal = new BigDecimal(-3.000);
        BigDecimal bigDecimal1 = new BigDecimal(-3.0);

        System.out.println(bigDecimal.compareTo(bigDecimal1));
    }
}
