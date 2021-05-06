package com.example.demo.collectors;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Alibaba {

    private BigDecimal amount;

    private BigDecimal size;

    private String name;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getSize() {
        return size;
    }

    public void setSize(BigDecimal size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Alibaba{" +
                "amount=" + amount +
                ", size=" + size +
                ", name='" + name + '\'' +
                '}';
    }


    public static void main(String[] args) {
        List<Alibaba> alibabaList = new ArrayList<>();
        Alibaba alibaba = new Alibaba();
        alibaba.setAmount(BigDecimal.ONE);
        alibaba.setSize(BigDecimal.ONE);

        Alibaba alibaba1 = new Alibaba();
        alibaba1.setAmount(BigDecimal.ONE);
        alibaba1.setSize(BigDecimal.ONE);

        List<Alibaba> alibabas = Stream.of(alibaba, alibaba1).collect(Collectors.toList());

        // 求数值的和
        BigDecimal bigDecimal = alibabas.stream().map(Alibaba::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add);

        System.out.println(bigDecimal);


    }
}
