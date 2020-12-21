package com.example.demo.localdate;

import java.time.LocalDate;

import static java.time.temporal.TemporalAdjusters.firstDayOfMonth;

public class LocalDateTest {

    public static void main(String[] args) {

        LocalDate localDate = LocalDate.now();

        while (localDate.isBefore(LocalDate.of(2022,12,31))){
            System.out.println(localDate.with(firstDayOfMonth()).plusDays(24));
            localDate = localDate.plusDays(1);
        }
    }
}
