package com.bigelmo.spring.market;

import java.math.BigDecimal;

public class Product {

    private final int id;
    private final String name;
    private BigDecimal cost;

    public Product(int id, String name, BigDecimal cost) {
        this.name = name;
        this.cost = cost;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", name='" + name + '\'' +
                ", cost=" + cost;
    }
}
