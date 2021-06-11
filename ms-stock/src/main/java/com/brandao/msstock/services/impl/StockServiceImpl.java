package com.brandao.msstock.services.impl;

import com.brandao.msstock.dto.StockDTO;
import com.brandao.msstock.services.StockService;
import org.springframework.stereotype.Service;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import java.io.IOException;
import java.util.Optional;

@Service
public class StockServiceImpl implements StockService {

    @Override
    public StockDTO getStockPrice(String stockName) throws IOException {

        Stock stock = YahooFinance.get(stockName.toUpperCase() + ".SA");

        if(Optional.ofNullable(stock).isEmpty()) return null;

        return StockDTO.builder()
                .company(stock.getName())
                .price(stock.getQuote(true).getPrice())
                .build();
    }
}
