package com.example.demo.calculate.operator;

public class OperatorAverageCapicalAndInterest extends Operator {

    private static final double lrprate;

    private static final double actrualrate;

    private static final double actralgjjrate;

    private static final double ONE_YEAR_MONTH = 12;

    private static final double GJJ_RATE = 0.0325;


    static {
        lrprate = 0.0545;
        actrualrate = lrprate / ONE_YEAR_MONTH;
        actralgjjrate = GJJ_RATE / ONE_YEAR_MONTH;
    }

    @Override
    public double execute(double totalmoney, double year) {


        return totalmoney * calculateMonthRate(year);
    }

    public double executegjj(double totalmoney, double year) {

        return totalmoney * calculategjjMonthRate(year);
    }

    private double calculateMonthRate(double year) {

        double totolmonth = year * ONE_YEAR_MONTH;
        return actrualrate * Math.pow(1 + actrualrate, totolmonth) / (Math.pow((1 + actrualrate), totolmonth) - 1);

    }

    private double calculategjjMonthRate(double year) {

        double totolmonth = year * ONE_YEAR_MONTH;
        return actralgjjrate * Math.pow(1 + actralgjjrate, totolmonth) / (Math.pow((1 + actralgjjrate), totolmonth) - 1);

    }
}
