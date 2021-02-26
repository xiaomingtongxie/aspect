package com.example.demo.objectalalize;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.info.GraphLayout;
import org.openjdk.jol.vm.VM;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

/**
 *  jol java 对象 布局 分析
 */

public class JvmDistribute {

  private static    Logger logger = LoggerFactory.getLogger(JvmDistribute.class);

    public static void main(String[] args) {
        // 查看虚拟机参数
        logger.info("{}", VM.current().details());

        // 分析String

        logger.info("{}", ClassLayout.parseClass(String.class).toPrintable());


        // 分析string 对象

        logger.info("{}",ClassLayout.parseInstance("xiaomingtongxie").toPrintable());
        logger.info("{}",ClassLayout.parseInstance("com.example.demo.objectalalize.JvmDistribute - java.lang.String object internals").toPrintable());

        // 分析数组

        logger.info("{}",ClassLayout.parseClass(byte[].class).toPrintable());

        logger.info("{}",ClassLayout.parseInstance("xiaomingtongxie".getBytes()).toPrintable());

        // 分析拆装箱

        logger.info("{}",ClassLayout.parseClass(Long.class).toPrintable());
        logger.info("{}",ClassLayout.parseInstance(1234567890111112L).toPrintable());

        // 分析引用关系

        HashMap hashMap= new HashMap();
        hashMap.put("xiaomingtongxie","xiaomingtongxie98%");
        logger.info("{}", GraphLayout.parseInstance(hashMap).toPrintable());



    }
}
