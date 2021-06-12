package com.brandao.mstransaction.services;

import com.brandao.mstransaction.dto.Order;

public interface TransactionService {

    Order resumeOrder(String stockName, Long amount);

}
