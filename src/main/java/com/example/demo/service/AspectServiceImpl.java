package com.example.demo.service;

import com.example.demo.AspectBean;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service("aspectService")
public class AspectServiceImpl implements AspectService {

    @Override
    public AspectBean testAspect(AspectBean aspectBean) throws InterruptedException {
        Thread.sleep(1000);
        aspectBean.setSex(0);
        aspectBean.setBirthday(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date().getTime()));
        return aspectBean;
    }

    @Override
    public boolean init() {
        return false;
    }
}
