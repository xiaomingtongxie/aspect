package com.example.demo.calculate.operator;


import com.example.demo.calculate.Enum.Operation;

public class Operator {

    private double year;
    private double totalmoney;

    private Operation operation;

    public double getYear() {
        return year;
    }

    public void setYear(double year) {
        this.year = year;
    }

    public double getTotalmoney() {
        return totalmoney;
    }

    public void setTotalmoney(double totalmoney) {
        this.totalmoney = totalmoney;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public double execute(double param1, double param2) {
        return 0;
    }

}
