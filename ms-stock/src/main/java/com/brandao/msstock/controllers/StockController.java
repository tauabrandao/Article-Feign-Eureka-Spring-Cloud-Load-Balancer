package com.brandao.msstock.controllers;

import com.brandao.msstock.dto.StockDTO;
import com.brandao.msstock.services.StockService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("/stock")
public class StockController {

    private final StockService service;

    public StockController(StockService service) {
        this.service = service;
    }

    @GetMapping("/price/{name}")
    public ResponseEntity<Object> getStockPrice(@PathVariable String name) throws IOException {
        StockDTO dto = service.getStockPrice(name);

        if(Optional.ofNullable(dto).isEmpty())
            return ResponseEntity.ok("stock not found");

        return ResponseEntity.ok(dto);
    }
}
