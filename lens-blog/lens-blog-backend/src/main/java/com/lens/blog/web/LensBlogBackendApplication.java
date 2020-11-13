package com.lens.blog.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.oas.annotations.EnableOpenApi;

@EnableScheduling
@EnableTransactionManagement
@SpringBootApplication
@EnableOpenApi
@EnableDiscoveryClient
// 开启异步
@EnableAsync
@EnableFeignClients("com.lens.blog.common.feign")
@ComponentScan(basePackages = {
        "com.lens.blog.common.config",
        "com.lens.blog.common.fallback",
        "com.lens.blog.utils",
        "com.lens.blog.xo.utils",
        "com.lens.blog.web",
        "com.lens.blog.xo.service"})
public class LensBlogBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(LensBlogBackendApplication.class, args);
    }

}
