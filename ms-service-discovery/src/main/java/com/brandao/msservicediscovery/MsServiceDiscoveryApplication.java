package com.brandao.msservicediscovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MsServiceDiscoveryApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsServiceDiscoveryApplication.class, args);
    }

}
