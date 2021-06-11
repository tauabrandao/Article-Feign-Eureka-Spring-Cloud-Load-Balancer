package com.brandao.msstock.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Builder
@Getter
@Setter
public class StockDTO {

    private String company;
    private BigDecimal price;

}
