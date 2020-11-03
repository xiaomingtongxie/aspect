package com.example.demo.calculate.Enum;

public enum Operation {
    PLUS("+", "plus"),
    MINUS("-", "minus"),
    TIMES("*", "times"),
    DIVIDE("/", "divide"),
    AVERAGECAPICALINTERREST("avg","average");

    private String operator;
    private String desc;

    Operation(String operator, String desc) {
        this.operator = operator;
        this.desc = desc;
    }

}
