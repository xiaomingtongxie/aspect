package com.example.demo.calculate.operator;

public class OperatorAverageCapicalAndInterest extends Operator {

    private static final double lrprate;

    private static final double actrualrate;

    private static final double ONE_YEAR_MONTH = 12;

    static {
        lrprate = 0.048;
        actrualrate = lrprate * (1 + 0.2);
    }

    @Override
    public double execute(double year, double totalmoney) {

        return totalmoney * calculateMonthRate(year);
    }


    private double calculateMonthRate(double year) {

        double totolmonth = year * ONE_YEAR_MONTH;
        return actrualrate * Math.pow(1 + actrualrate, totolmonth) / (Math.pow((1 + actrualrate), totolmonth) - 1);

    }
}
