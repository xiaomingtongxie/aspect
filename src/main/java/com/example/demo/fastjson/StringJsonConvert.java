package com.example.demo.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringJsonConvert {








    public static void main(String[] args) {
        Student student = new Student();
        student.setName("xmtx");
        student.setSex("man");

        Student student1 = JSONObject.parseObject(JSON.toJSONString(student), Student.class);
        List<Student> studentList = Stream.of(student).collect(Collectors.toList());
        String jsonString = JSON.toJSONString(studentList);

        System.out.println("json string is : ==== " + jsonString);

        List<Student> students = JSONObject.parseArray(jsonString, Student.class);
        System.out.println("after transfer: " + students.toString());

    }

}

