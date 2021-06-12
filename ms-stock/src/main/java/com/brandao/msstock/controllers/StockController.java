package com.brandao.msstock.controllers;

import com.brandao.msstock.services.StockService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/stock")
public class StockController {

    private final StockService service;

    private final Environment environment;

    private Logger logger = LoggerFactory.getLogger(StockController.class);

    public StockController(StockService service, Environment environment) {
        this.service = service;
        this.environment = environment;
    }

    @GetMapping("/price/{name}")
    public ResponseEntity<Object> getStockPrice(@PathVariable String name) throws IOException {

        logger.info("The instance running on port %s was called to fetch the stock details"
                .formatted(environment.getProperty("local.server.port")));

        return ResponseEntity.ok(service.getStockPrice(name));
    }
}
