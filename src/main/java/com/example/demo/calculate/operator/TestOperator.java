package com.example.demo.calculate.operator;

import com.example.demo.calculate.Enum.Operation;
import com.example.demo.calculate.factory.OperateFactory;

public class TestOperator {

    public static void main(String[] args) {

        double year =30;
        double totalmoney = 106*10000;
        double totalgjjmoney = 50*10000;
        OperatorAverageCapicalAndInterest operator = (OperatorAverageCapicalAndInterest)OperateFactory.getOperatoreInstance(Operation.AVERAGECAPICALINTERREST);

        System.out.printf("result:"+(operator.execute(totalmoney,year)+operator.executegjj(totalgjjmoney,year)));
    }
}
