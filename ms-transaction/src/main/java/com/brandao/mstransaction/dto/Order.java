package com.brandao.mstransaction.dto;

import lombok.Getter;

import java.math.BigDecimal;

public class Order extends StockDTO{

    @Getter
    private BigDecimal totalPrice;

    @Getter
    private Long amount;

    public Order(String company, BigDecimal price, BigDecimal totalPrice, Long amount) {
        super(company, price);
        this.totalPrice = totalPrice;
        this.amount = amount;
    }

}
