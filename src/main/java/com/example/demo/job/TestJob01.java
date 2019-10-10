package com.example.demo.job;

import net.javacrumbs.shedlock.core.SchedulerLock;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@EnableScheduling
public class TestJob01 {


    @Scheduled(cron = "0/5 * * * * ?")
    @SchedulerLock(name = "test4-task", lockAtMostForString = "PT28M", lockAtLeastForString = "PT28M")
    public void execute1() {
        String curName = Thread.currentThread().getName();
        System.out.println("当前时间:" + LocalDateTime.now() + "  任务execute4对应的线程名: " + curName);
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Scheduled(cron = "0/5 * * * * ?")
    @SchedulerLock(name = "test5-task", lockAtMostForString = "PT28M", lockAtLeastForString = "PT28M")
    public void execute2() {

        String curName = Thread.currentThread().getName();
        System.out.println("当前时间:" + LocalDateTime.now() + "  任务execute5对应的线程名: " + curName);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Scheduled(cron = "0/10 * * * * ?")
    @SchedulerLock(name = "test6-task", lockAtMostForString = "PT28M", lockAtLeastForString = "PT28M")
    public void execute3() {

        String curName = Thread.currentThread().getName();
        System.out.println("当前时间:" + LocalDateTime.now() + "  任务execute6对应的线程名: " + curName);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
