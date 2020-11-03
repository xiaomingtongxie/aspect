package com.example.demo.calculate.operator;

import com.example.demo.calculate.operator.Operator;

public class OperatorDevide extends Operator {

    @Override
    public double execute(double param1, double param2) {
        if (param2 != 0) {
            return param1 / param2;
        }
        return param2;
    }

}
