package com.example.demo.spring.bean;

import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * 测试 spring bean 创建过程
 */
public class TestBeancreateProcess {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();

//        ac.getBeanFactory().registerSingleton("zzz", new Z());

        ac.addBeanFactoryPostProcessor(new Z());
        ac.addBeanFactoryPostProcessor(new E());
        ac.register(App.class);
        ac.refresh();

//        ac.getBean("zzz");

//        System.out.println(ac.getBean(X.class));
//        System.out.println(ac.getBean(Y.class));
//        System.out.println(ac.getBean(App.class));

        /**
         *  bean 创建过程伪代码
         */

//        List<Class> list= null;
//        for (Class aClass : list) {
//            GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
//            genericBeanDefinition.setScope("singleton");
//        }
    }
}
