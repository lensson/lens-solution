package com.lens.gate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class LensGateApplication {

    public static void main(String[] args) {
        SpringApplication.run(LensGateApplication.class, args);
    }

}
