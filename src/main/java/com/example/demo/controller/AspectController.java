package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.AspectBean;
import com.example.demo.entity.UserInfo;
import com.example.demo.service.AspectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;


@RestController
@RequestMapping(value = "/aspect")
@Api(value = "切面模块", tags = "切面模块")

public class AspectController {

    private static final Logger log = LoggerFactory.getLogger(AspectController.class);

    @Autowired
    private AspectService aspectService;

    @ApiOperation(value = "测试getaspect")
    @GetMapping(value = "/getaspect")
    public String getAspect(@ApiParam("名称") String name,
                            @ApiParam Integer age) throws InterruptedException {
        AspectBean aspectBean = new AspectBean();
        aspectBean.setAge(age);
        aspectBean.setBirthday(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date().getTime()));
        aspectBean.setSex(1);
        aspectBean.setName(name);
        return JSON.toJSONString(aspectService.testAspect(aspectBean));
    }

    @PostMapping(value = "/postaspect")
    public String postAspect(@RequestBody AspectBean aspectBean) throws InterruptedException {
        return JSON.toJSONString(aspectService.testAspect(aspectBean));
    }

    @GetMapping(value = "/init")
    public boolean init() {
        return aspectService.init();
    }


    @GetMapping(value = "/basic")
    public String basic() {
        UserInfo userInfo = new UserInfo();
        userInfo.setField4("243535236");
        System.out.println(userInfo.toString());
        return userInfo.toString();
    }
}
