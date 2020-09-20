package com.example.demo.spring.beanlifecycle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Testlife {

    /**
     * spring容器对象 AnnotationConfigApplicationContext被实例化了，然后调用refesh() 方法初始化
     * 1 . 扫描包--beandefine -- put bdmap
     * 2. 变量这个bdmap，依次获取beandefinition对象
     * 3. 去解析-- 把beandefinition对象中描述bean的信息得到
     * 4. volidate 验证是否单例，是否抽象 是否factorybean 是否被创建……
     * 5. 得到class的对象
     * 6. 推断构造方法 一个类可以提供多个构造方法 spring自实例化bean的时候需要用哪个构造方法
     * 7. 得到一个构造方法-- 通过反射然后直接实例化这个对象（这个时候还不是一个bean)
     * 8. 做一个循环依赖的判断，然后对循环依赖提供支持
     * 9. 合并beandefinition( 不需要关心）
     * 10. 判断当前容器是否需要完成自动注入 程序员可以扩展的
     * 11. 如果需要完成注入 完成属性填充 ---- 自动注入
     * 12. 执行部分aware接口（很多的aware 这里不会全部执行 只会执行一部分）
     * 13. (beanpostprofessor before ) 执行部分生命周期初始化回调（注解版本）执行部分aware接口的回调
     * 14. 执行接口版的生命周期回调
     * 15. (Beanpostprofessor after) 完成的事件发布 完成aop的代理
     * @param args
     */
    public static void main(String[] args) {

        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(Config.class);

        System.out.println(ac.getBean(A.class));
    }
}
