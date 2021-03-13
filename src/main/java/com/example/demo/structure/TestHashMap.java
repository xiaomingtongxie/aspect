package com.example.demo.structure;

import java.util.HashMap;
import java.util.Map;

public class TestHashMap {


    public static void main(String[] args) {
        Map<String,Object> map = new HashMap<>();
        map.put(null,2333);
        System.out.println(map.get(null));
    }
}
