package com.lens.wx.gzh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@EnableCaching
@EnableDiscoveryClient
public class LensGzhBackendBootApplication {
    public static void main(String[] args) { SpringApplication.run(LensGzhBackendBootApplication.class, args);
    }

}