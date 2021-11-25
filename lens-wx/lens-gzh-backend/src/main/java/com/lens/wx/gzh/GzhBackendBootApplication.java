package com.lens.wx.gzh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;


@SpringBootApplication
@EnableAsync
@EnableCaching
public class GzhBackendBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(GzhBackendBootApplication.class, args);
    }

}
