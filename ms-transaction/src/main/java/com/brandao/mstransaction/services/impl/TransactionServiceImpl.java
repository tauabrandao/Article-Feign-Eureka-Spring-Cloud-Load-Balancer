package com.brandao.mstransaction.services.impl;

import com.brandao.mstransaction.dto.Order;
import com.brandao.mstransaction.dto.StockDTO;
import com.brandao.mstransaction.feign.TransactionProxy;
import com.brandao.mstransaction.services.TransactionService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionProxy proxy;

    public TransactionServiceImpl(TransactionProxy proxy) {
        this.proxy = proxy;
    }

    @Override
    public Order resumeOrder(String stockName, Long amount) {
        StockDTO stock = proxy.getStockAndPrice(stockName);

        if (Optional.ofNullable(stock).isEmpty()) return null;

        return new Order(stock.getCompany(),
                stock.getPrice(),
                calculateTotalPrice(stock, amount),
                amount);
    }

    private BigDecimal calculateTotalPrice(StockDTO stock, Long amount) {
        return BigDecimal.valueOf(stock.getPrice().doubleValue() * amount);
    }
}
