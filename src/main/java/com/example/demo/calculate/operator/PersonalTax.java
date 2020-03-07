package com.example.demo.calculate.operator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PersonalTax {

    private static final BigDecimal salary_5000 = BigDecimal.valueOf(5000);
    private static final BigDecimal salary_8000 = BigDecimal.valueOf(8000);
    private static final BigDecimal salary_17000 = BigDecimal.valueOf(17000);
    private static final BigDecimal salary_30000 = BigDecimal.valueOf(30000);
    private static final BigDecimal salary_40000 = BigDecimal.valueOf(40000);
    private static final BigDecimal salary_60000 = BigDecimal.valueOf(60000);
    private static final BigDecimal salary_85000 = BigDecimal.valueOf(85000);

    private static final BigDecimal tax_5000_8000 = BigDecimal.valueOf(90);
    private static final BigDecimal tax_8000_17000 = BigDecimal.valueOf(900);
    private static final BigDecimal tax_17000_30000 = BigDecimal.valueOf(2600);
    private static final BigDecimal tax_30000_40000 = BigDecimal.valueOf(2500);
    private static final BigDecimal tax_40000_60000 = BigDecimal.valueOf(6000);
    private static final BigDecimal tax_60000_85000 = BigDecimal.valueOf(8750);



    static BigDecimal calculateTax(BigDecimal salary ){
        BigDecimal tax = BigDecimal.ZERO;

        if(salary.compareTo(salary_5000)<=0){
            return tax;
        }
        if(salary.compareTo(salary_5000)>0 && salary.compareTo(salary_8000)<=0){
            tax = tax.add(salary.subtract(salary_5000).
                    multiply(BigDecimal.valueOf(3).divide(BigDecimal.valueOf(100))));
        }

        if(salary.compareTo(salary_8000)>0 && salary.compareTo(salary_17000)<=0){
            tax = tax.add(tax_5000_8000).add(salary.subtract(salary_8000).
                    multiply(BigDecimal.valueOf(10).divide(BigDecimal.valueOf(100))));
        }
        if(salary.compareTo(salary_17000)>0 && salary.compareTo(salary_30000)<=0){
            tax = tax.add(tax_5000_8000).add(tax_8000_17000).add(salary.subtract(salary_17000).
                    multiply(BigDecimal.valueOf(20).divide(BigDecimal.valueOf(100))));
        }

        if(salary.compareTo(salary_30000)>0 && salary.compareTo(salary_40000)<=0){
            tax = tax.add(tax_5000_8000)
                    .add(tax_8000_17000)
                    .add(tax_17000_30000)
                    .add(salary.subtract(salary_30000).
                    multiply(BigDecimal.valueOf(25).divide(BigDecimal.valueOf(100))));
        }

        if(salary.compareTo(salary_40000)>0 && salary.compareTo(salary_60000)<=0){
            tax = tax.add(tax_5000_8000)
                    .add(tax_8000_17000)
                    .add(tax_17000_30000)
                    .add(tax_30000_40000)
                    .add(salary.subtract(salary_40000).
                    multiply(BigDecimal.valueOf(30).divide(BigDecimal.valueOf(100))));
        }

        if(salary.compareTo(salary_60000)>0 && salary.compareTo(salary_85000)<=0){
            tax = tax.add(tax_5000_8000)
                    .add(tax_8000_17000)
                    .add(tax_17000_30000)
                    .add(tax_30000_40000)
                    .add(tax_40000_60000)
                    .add(salary.subtract(salary_60000).
                    multiply(BigDecimal.valueOf(35).divide(BigDecimal.valueOf(100))));
        }

        if(salary.compareTo(salary_85000)>0 ){
            tax = tax.add(tax_5000_8000)
                    .add(tax_8000_17000)
                    .add(tax_17000_30000)
                    .add(tax_30000_40000)
                    .add(tax_40000_60000)
                    .add(tax_60000_85000)
                    .add(salary.subtract(salary_85000).
                    multiply(BigDecimal.valueOf(45).divide(BigDecimal.valueOf(100))));
        }


        return tax;

    }
    public static void main(String[] args) {

        List<BigDecimal> salarylist = new ArrayList<>();
        salarylist.add(BigDecimal.valueOf(5000));
        salarylist.add(BigDecimal.valueOf(8000));
        salarylist.add(BigDecimal.valueOf(15450));
        salarylist.add(BigDecimal.valueOf(17000));
        salarylist.add(BigDecimal.valueOf(17867));
        salarylist.add(BigDecimal.valueOf(30000));
        salarylist.add(BigDecimal.valueOf(28750));
        salarylist.add(BigDecimal.valueOf(40000));
        salarylist.add(BigDecimal.valueOf(60000));
        salarylist.add(BigDecimal.valueOf(85000));
        salarylist.add(BigDecimal.valueOf(7000));
        salarylist.add(BigDecimal.valueOf(10000));
        salarylist.add(BigDecimal.valueOf(19000));
        salarylist.add(BigDecimal.valueOf(35000));
        salarylist.add(BigDecimal.valueOf(50000));
        salarylist.add(BigDecimal.valueOf(80000));
        salarylist.add(BigDecimal.valueOf(100000));



        for(BigDecimal bigDecimal :salarylist){
        System.out.println("工资===》"+bigDecimal+"====="+" 应缴纳个税："+calculateTax(bigDecimal));

        }

    }

//    2019年新个税税率表
//
//　　1、工资范围在1-5000元之间的，包括5000元，适用个人所得税税率为0%;
//
//　　2、工资范围在5000-8000元之间的，包括8000元，适用个人所得税税率为3%;
//
//　　3、工资范围在8000-17000元之间的，包括17000元，适用个人所得税税率为10%;
//
//　　4、工资范围在17000-30000元之间的，包括30000元，适用个人所得税税率为20%;
//
//　　5、工资范围在30000-40000元之间的，包括40000元，适用个人所得税税率为25%;
//
//　　6、工资范围在40000-60000元之间的，包括60000元，适用个人所得税税率为30%;
//
//　　7、工资范围在60000-85000元之间的，包括85000元，适用个人所得税税率为35%;
//
//　　8、工资范围在85000元以上的，适用个人所得税税率为45%。


}
