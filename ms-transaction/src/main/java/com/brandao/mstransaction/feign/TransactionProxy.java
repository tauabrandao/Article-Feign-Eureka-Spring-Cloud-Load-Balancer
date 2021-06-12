package com.brandao.mstransaction.feign;

import com.brandao.mstransaction.dto.StockDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-stock")
public interface TransactionProxy {

    @GetMapping("/stock/price/{name}")
    StockDTO getStockAndPrice(@PathVariable String name);

}
