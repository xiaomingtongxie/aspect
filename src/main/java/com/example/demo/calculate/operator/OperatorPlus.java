package com.example.demo.calculate.operator;

import com.example.demo.calculate.operator.Operator;

public class OperatorPlus extends Operator {

    @Override
    public double execute(double param1, double param2) {

        return param1 + param2;
    }
}
