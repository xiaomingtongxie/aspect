package com.example.demo.calculate.operator;

import com.example.demo.calculate.Enum.Operation;
import com.example.demo.calculate.factory.OperateFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestOperator {

    public static void main(String[] args) {

        Integer year = Integer.valueOf(30);
        double totalmoney = 100 * 10000;
        double totalgjjmoney = 50 * 10000;
        OperatorAverageCapicalAndInterest operator = (OperatorAverageCapicalAndInterest) OperateFactory.getOperatoreInstance(Operation.AVERAGECAPICALINTERREST);

        System.out.println("等额本息每月还款:" + (operator.execute(totalmoney, year) + operator.executegjj(totalgjjmoney, year)));

        Operator operator1 = new Operator();
        operator1.setYear(Integer.valueOf(2019));
        operator1.setTotalmoney(2019);
        Operator operator2 = new Operator();
        operator2.setYear(Integer.valueOf(2020));
        operator2.setTotalmoney(2020);

        Operator operator3 = new Operator();
        operator3.setYear(Integer.valueOf(2020));
        operator3.setTotalmoney(2020);
        List<Operator> operators = new ArrayList<>();
        operators.add(operator1);
        operators.add(operator2);
        operators.add(operator3);


      Map<Integer,Long> map = operators.parallelStream().collect(
                Collectors.groupingBy(o -> o.getYear(), Collectors.counting()));

//
//        for (Map.Entry<Integer,Long> entry : map.entrySet()){
//            if (entry.getValue()>=2){
//                System.out.println("有分组后大于2的organId.");
//            }
//        }
//        System.out.println(map);



    }
}
