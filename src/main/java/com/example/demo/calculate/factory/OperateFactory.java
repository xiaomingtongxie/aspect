package com.example.demo.calculate.factory;

import com.example.demo.calculate.Enum.Operation;
import com.example.demo.calculate.operator.*;

public class OperateFactory {

    public static Operator getOperatoreInstance(Operation operation) {
        switch (operation) {
            case DIVIDE:
                return new OperatorDevide();
            case TIMES:
                return new OperatorTimes();
            case PLUS:
                return new OperatorPlus();
            case MINUS:
                return new OperatorMinus();
            case AVERAGECAPICALINTERREST:
                return new OperatorAverageCapicalAndInterest();
        }
        throw new AssertionError("unknown operation. ");

    }
}
