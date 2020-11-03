package com.example.demo.service;

import com.example.demo.AspectBean;
import com.example.demo.annotation.Log;

//@Log(value = "aspect test",ignore = true)
@Log(value = "aspect test",ignore = false)
public interface AspectService {

//    @Log("this is a method for test aspect.")
    public AspectBean testAspect(AspectBean aspectBean) throws InterruptedException;

    public boolean init();

}
