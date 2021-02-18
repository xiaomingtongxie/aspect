package com.example.demo.sync;


import com.alibaba.fastjson.JSON;
import com.example.demo.AspectBean;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping(value = "/task")
public class SyncTask {
    @PostMapping(value = "/sync")
    public String testSync() throws InterruptedException {

        // 开启异步任务执行任务
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() ->
                {
                    try {
                        System.out.println("我进到异步方法里面了=======================");
                        this.sync();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return "耗时任务完成";
                }
        );
        try {
            // 必须在future.complete之前sleep 异步线程才能执行
            Thread.sleep(200);
            future.complete("执行成功！");
            // 这里直接返回前端结果 ,这里sleep无效
//            Thread.sleep(2000);
            return future.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } finally {
            // do nothing
        }
        // 这里主线程不休眠的话，异步线程池会秒结束，这个不知道什么机制，需要研究一下，这里sleep无效
//        Thread.sleep(2000);
        return "方法结束";
    }


    /**
     * 这是一个非常非常耗时的接口方法
     *
     * @return
     * @throws InterruptedException
     */
    private String sync() throws InterruptedException {

        System.out.println("执行到耗时方法了！");
        Thread.sleep(1000 * 10);
        return "success";
    }

}
