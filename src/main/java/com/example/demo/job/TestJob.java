package com.example.demo.job;

import net.javacrumbs.shedlock.core.SchedulerLock;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@EnableScheduling
public class TestJob {


    @Scheduled(cron = "0/5 * * * * ?")
    @SchedulerLock(name = "test1-task", lockAtMostForString = "PT28M", lockAtLeastForString = "PT28M")
    public void execute1() {
        String curName = Thread.currentThread().getName();
        System.out.println("当前时间:" + LocalDateTime.now() + "  任务execute1对应的线程名: " + curName);
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Scheduled(cron = "0/5 * * * * ?")
    @SchedulerLock(name = "test2-task", lockAtMostForString = "PT28M", lockAtLeastForString = "PT28M")
    public void execute2() {

        String curName = Thread.currentThread().getName();
        System.out.println("当前时间:" + LocalDateTime.now() + "  任务execute2对应的线程名: " + curName);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Scheduled(cron = "0/10 * * * * ?")
    @SchedulerLock(name = "test3-task", lockAtMostForString = "PT28M", lockAtLeastForString = "PT28M")
    public void execute3() {

        String curName = Thread.currentThread().getName();
        System.out.println("当前时间:" + LocalDateTime.now() + "  任务execute3对应的线程名: " + curName);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
