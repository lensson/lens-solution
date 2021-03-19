package com.lens.nsgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;



@EnableDiscoveryClient
@SpringBootApplication
public class LensNsgatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(LensNsgatewayApplication.class, args);
    }

}
