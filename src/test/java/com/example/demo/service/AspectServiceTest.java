package com.example.demo.service;

import com.example.demo.AspectBean;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.testng.annotations.BeforeMethod;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.powermock.api.mockito.PowerMockito.when;

@SpringBootTest
public class AspectServiceTest extends AbstractTestNGSpringContextTests {

    private MockMvc mockmvc;
    @Autowired
    private WebApplicationContext wac;

    @Mock
    private AspectService aspectService;


    @BeforeMethod
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        this.mockmvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }


    @Test
    public void testAspect() throws Exception {
        aspectService = Mockito.mock(AspectService.class);
        when(aspectService.testAspect(any())).thenReturn(new AspectBean());
        AspectBean aspectBean = new AspectBean();
        aspectBean.setName("before name.");
        aspectBean.setBirthday(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date().getTime()));
        aspectBean.setAge(10);
        aspectBean.setSex(0);
        aspectService.testAspect(aspectBean);
    }

}