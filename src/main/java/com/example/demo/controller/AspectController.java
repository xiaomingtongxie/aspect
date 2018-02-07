package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.AspectBean;
import com.example.demo.service.AspectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;


@RestController
@RequestMapping(value = "/aspect")
public class AspectController {

    private static final Logger log = LoggerFactory.getLogger(AspectController.class);

    @Autowired
    private AspectService aspectService;

    @GetMapping(value = "/testaspect")
    public String testAspect() throws InterruptedException {

        AspectBean aspectBean = new AspectBean();
        aspectBean.setAge(18);
        aspectBean.setBirthday(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date().getTime()));
        aspectBean.setSex(1);
        aspectBean.setName("aspect");
        return JSON.toJSONString(aspectService.testAspect(aspectBean));
    }

    @GetMapping(value = "/init")
    public boolean init() {
        return aspectService.init();
    }
}
