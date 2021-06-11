package com.brandao.msstock.services;

import com.brandao.msstock.dto.StockDTO;

import java.io.IOException;

public interface StockService {

    StockDTO getStockPrice(String stockName) throws IOException;

}
